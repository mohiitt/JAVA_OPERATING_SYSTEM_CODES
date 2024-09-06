package firstproject;

import java.util.*;

public class fcfs {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of processes: ");
		int n = sc.nextInt();
		int pid[] = new int[n];
		int ar[] = new int[n];
		int bt[] = new int[n];
		int ct[] = new int[n];
		int ta[] = new int[n];
		int wt[] = new int[n];
		int temp;
		float avgwt = 0, avgta = 0;

		for (int i = 0; i < n; i++) {
			System.out.println("enter process " + (i + 1) + "arrival time: ");
			ar[i] = sc.nextInt();
			System.out.println("enter process " + (i + 1) + "burst time :");
			bt[i] = sc.nextInt();
			pid[i] = i + 1;
		}
		// bubble sort(ing) according to arrival times
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n - (i + 1); j++)// The (i+1) is used to ensure that in each iteration, the loop
													// considers one less element at the end of the array, as the
													// largest elements are moved to their correct positions.
			{
				if (ar[j] > ar[j + 1])
				{
					temp = ar[j];
					ar[j] = ar[j + 1];
					ar[j + 1] = temp;
					
					temp = bt[j];
					bt[j] = bt[j + 1];
					bt[j + 1] = temp;
					
					temp = pid[j];
					pid[j] = pid[j + 1];
					pid[j + 1] = temp;
				}
			}
		}

		// finding completion times
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				ct[i] = ar[i] + bt[i];
			} 
			else {
				if (ar[i] > ct[i - 1]) {
					ct[i] = ar[i] + bt[i];
				} else {
					ct[i] = ct[i - 1] + bt[i];
				}
			}
			ta[i] = ct[i] - ar[i];
			wt[i] = ta[i] - bt[i];
			avgwt += wt[i];
			avgta += ta[i];
		}
		System.out.println("\nPno.\t AT\t\t BT\t\t CT  \t\t TAT \t\t WT");
		for(int i=0;i<n;i++)
		{
			System.out.println("\n"+pid[i] + "\t\t" + ar[i] + "\t\t" + bt[i] + "\t\t" + ct[i] +"\t\t" + ta[i] + "\t\t" +wt[i]);
			
		}
		sc.close();
		System.out.println("\nAverage waiting time: "+(avgwt/n));
		System.out.println("Average turn around time: "+(avgta/n));
	}
}