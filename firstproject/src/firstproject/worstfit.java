package firstproject;

import java.util.*;

public class worstfit {
	public static void wfit(int blocksize[], int m, int procsize[], int n) {
		int allocation[] = new int[n];
		for (int i = 0; i < allocation.length; i++) {
			allocation[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			int wstidx = -1;
			for (int j = 0; j < m; j++) {
				if (blocksize[j] >= procsize[i]) {
					if (wstidx == -1 || blocksize[wstidx] < blocksize[j]) {
						wstidx = j;
					}
				}
			}

			if (wstidx != -1) {
				allocation[i] = wstidx;
				blocksize[wstidx] -= procsize[i];
			}

		}

		System.out.println("\nProcessno.\tProcess_size\tblockno.");
		for (int i = 0; i < n; i++) {
			System.out.print(" " + (i + 1) + "\t\t\t" + procsize[i] + "\t\t\t");
			if (allocation[i] != -1) {
				System.out.print(allocation[i] + 1);
			} else {
				System.out.println("not allocated");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("WORST FIT MEMORY ALLOCATION");
		int m;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of blocks : ");
		m = sc.nextInt();
		System.out.println("Enter block sizes : ");
		int[] blocksize = new int[10];
		for (int i = 0; i < m; i++) {
			blocksize[i] = sc.nextInt();
		}
		int n;
		System.out.println("Enter number of processes :");
		n = sc.nextInt();
		System.out.println("Enter process sizes : ");
		int[] procsize = new int[10];
		for (int i = 0; i < n; i++) {
			procsize[i] = sc.nextInt();
		}
		sc.close();
		wfit(blocksize, m, procsize, n);

	}

}
