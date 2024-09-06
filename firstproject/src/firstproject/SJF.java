package firstproject;
import java.util.*;
public class SJF {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of processes : ");
		int n = sc.nextInt();
		int pid[] = new int[n];
		int at[] = new int[n];
		int bt[] = new int[n];
		int ct[] = new int[n];// completion time
		int tat[] = new int[n];
		int wt[] = new int[n];
		int flag[] = new int[n];// flag for checking process is completed or not
		int k[] = new int[n];// stores remaining burst time

		int i = 0, syst = 0, tot = 0;// syst=system time for keeping record of time completed
										// tot=to keep track of total number of completed process
		float avgwt = 0, avgtat = 0;// average waiting and turn around time

		for (i = 0; i < n; i++) {
			pid[i] = i + 1;// to ensure process number starts from 1
			System.out.println("enter process " + (i + 1) + " arrival time : ");
			at[i] = sc.nextInt();
			System.out.println("enter process " + (i + 1) + " burst time : ");
			bt[i] = sc.nextInt();
			k[i] = bt[i];
			flag[i] = 0;// f=0 means process is not completed/started,f=1 means completed;
		}

		while (true) {
			int min = 99, c = n;// c means current process number,min=minimum burst time;
			if (tot == n)
				break;// means all processes are executed,exit loop;
			for (i = 0; i < n; i++) {
				if ((at[i] <= syst) && (flag[i] == 0) && bt[i] < min) {
					min = bt[i];
					c = i;// assigning current process i to variable c;
				}
			}

			if (c == n)// means c is at last process
			{
				syst++;
			} // just increment system time until completed;
			else// c!=n;
			{
				bt[c]--; // start executing current process by decrementing bt;
				syst++;
				if (bt[c] == 0) {
					ct[c] = syst;// completion time is system time of current process;
					flag[c] = 1;// indicating process [c] is completed;
					tot++;// incrementing as one process is completed;
				}

			}
		} // end of while loop

		for (i = 0; i < n; i++)// calculates tat wt for each process and adds the value of wt and tat for
								// calculating averagewt/tat
		{
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] = k[i];
			avgwt += wt[i];
			avgtat += tat[i];
		}
		System.out.println("\n ------ SJF ------ \n");
		System.out.println("\nPno.\t\t AT \t\tBT \t\t CT \t\tTAT\t\t WT");

		for (i = 0; i < n; i++) {
			System.out.println(
					"\n" + pid[i] + "\t\t" + at[i] + "\t\t" + k[i] + "\t\t" + ct[i] + "\t\t" + tat[i] + "\t\t" + wt[i]);
		}
		System.out.println("\nAverage waiting time : " + (avgwt / n));
		System.out.println("\nAverage turnaround time : " + (avgtat / n));
		sc.close();
	}
}