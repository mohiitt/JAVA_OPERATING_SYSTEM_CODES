package firstproject;

import java.util.Scanner;

public class bw {
	public static void BestFit(int blocksize[], int m, int procsize[], int n) {
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
	public static void WorstFit(int blocksize[], int m, int procsize[], int n) {
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
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMemory Allocation Techniques:");
            System.out.println("1. Worst Fit");
            System.out.println("2. Best Fit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nWORST FIT MEMORY ALLOCATION\n");
                    int m;
                    System.out.print("Enter the number of block size: ");
                    m = sc.nextInt();
                    int[] blocksize = new int[10];
                    System.out.println("Enter the block size: ");
                    for (int i = 0; i < m; i++) {
                        blocksize[i] = sc.nextInt();
                    }

                    int n;
                    System.out.print("Enter the number of process size: ");
                    n = sc.nextInt();
                    int[] process_size = new int[10];
                    System.out.println("Enter the process size: ");
                    for (int i = 0; i < n; i++) {
                        process_size[i] = sc.nextInt();
                    }

                    WorstFit(blocksize, m, process_size, n);
                    break;

                case 2:
                    System.out.println("\nBEST FIT MEMORY ALLOCATION\n");
                    int mNext;
                    System.out.print("Enter the number of block size: ");
                    mNext = sc.nextInt();
                    int[] blockSizeNext = new int[10];
                    System.out.println("Enter the block size: ");
                    for (int i = 0; i < mNext; i++) {
                        blockSizeNext[i] = sc.nextInt();
                    }

                    int nNext;
                    System.out.print("Enter the number of process size: ");
                    nNext = sc.nextInt();
                    int[] processSizeNext = new int[10];
                    System.out.println("Enter the process size: ");
                    for (int i = 0; i < nNext; i++) {
                        processSizeNext[i] = sc.nextInt();
                    }

                    BestFit(blockSizeNext, mNext, processSizeNext, nNext);
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 3);

        sc.close();
    }
}
