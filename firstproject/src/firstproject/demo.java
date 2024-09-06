package firstproject;

import java.util.Scanner;

public class demo {
	static void printArr(int[] pid, int[] bt, int[] at, int[] ct, int[] tt, int[] wt) {
		for (int i = 0; i < at.length; i++) {
			System.out.println(pid[i] + "\t" + bt[i] + "\t" + at[i] + "\t" + ct[i] + "\t" + tt[i] + "\t" + wt[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total no of entries: ");
		int n = sc.nextInt(), processId[] = new int[n], brushTime[] = new int[n], arrivalTime[] = new int[n],
				completionTime[] = new int[n], turnAroundTime[] = new int[n], waitingTime[] = new int[n],
				remainingTime[] = new int[n];

		System.out.println("Enter quantum time: ");
		int quant = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print("Enter the processor id: ");
			processId[i] = sc.nextInt();
			System.out.print("Enter the arrival time: ");
			arrivalTime[i] = sc.nextInt();
			System.out.print("Enter the brush time: ");
			brushTime[i] = sc.nextInt();
			remainingTime[i] = brushTime[i];
		}

//		sorting arrival time
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arrivalTime[j] > arrivalTime[j + 1]) {
					int temp = arrivalTime[j];
					arrivalTime[j] = arrivalTime[j + 1];
					arrivalTime[j + 1] = temp;

					temp = processId[j];
					processId[j] = processId[j + 1];
					processId[j + 1] = temp;

					temp = brushTime[j];
					brushTime[j] = brushTime[j + 1];
					brushTime[j + 1] = temp;

					temp = remainingTime[j];
					remainingTime[j] = remainingTime[j + 1];
					remainingTime[j + 1] = temp;
				}
			}
		}
		int completed = 0, running = 0, time = 0;
		boolean found = true;
		while (completed < n) {
			time += quant;
			if (found) {
				remainingTime[running] -= quant;
				if (remainingTime[running] <= 0) {
					completed++;
					completionTime[running] = time + remainingTime[running];
					turnAroundTime[running]= completionTime[running] - arrivalTime[running];
					waitingTime[running] = turnAroundTime[running] - brushTime[running];
					time = time + remainingTime[running];
					remainingTime[running] = 0;
					found = false;
				}
			}
			
			int t = running;
			while (true) {
				t = (t + 1) % n;
				if (remainingTime[t] > 0) {
					running = t;
					found = true;
					break;					
				}
				if (completed == n)
					break;
			}
			

			for (int i = 0; i < n; i++) {
				System.out.println(processId[i] + " : " + remainingTime[i]);
				
			}
			System.out.println(time + "\n------------");
		}
		System.out.println("PID\tBRUSH\tARRIVAL\tCOMP\tTurnAr\tWaitTime");
		printArr(processId, brushTime, arrivalTime, completionTime, turnAroundTime, waitingTime);

		sc.close();
	}

}
