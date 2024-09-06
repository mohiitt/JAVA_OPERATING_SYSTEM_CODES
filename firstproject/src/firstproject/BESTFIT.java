package firstproject;

import java.util.Scanner;

public class BESTFIT {
	public static void bfit(int blocksize[], int m, int procsize[], int n) {
		int allocation[] = new int[n];
		for (int i = 0; i < allocation.length; i++) {
			allocation[i] = -1;
		}
		for (int i = 0; i < n; i++) {
			int bstidx = -1;
			for (int j = 0; j < m; j++) {
				if (blocksize[j] >= procsize[i]) {
					if (bstidx == -1 || blocksize[bstidx] >= blocksize[j]) {
						bstidx = j;
					}
				}
			}
			if (bstidx != -1) {
				allocation[i] = bstidx;
				blocksize[bstidx] -= procsize[i];

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
		int m;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of blocks: ");
		m = sc.nextInt();
		System.out.println("Enter block sizes : ");
		int[] blocksize = new int[10];
		for (int i = 0; i < m; i++) {
			blocksize[i] = sc.nextInt();
		}
		int n;
		System.out.println("Enter number of processes : ");
		n = sc.nextInt();
		System.out.println("Enter process sizes :");
		int[] procsize = new int[10];
		for (int i = 0; i < n; i++) {
			procsize[i] = sc.nextInt();
		}
		sc.close();
		bfit(blocksize, m, procsize, n);

	}
}
