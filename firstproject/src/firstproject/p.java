package firstproject;
import java.util.*;
public class p
{
	public static void firstFit(int blocksize[],int m, int process_size[],int n)
	{
		int allocation[]=new int[n];
		for (int i=0;i<allocation.length;i++)
		{
			allocation[i]=-1;
		}
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<m;j++)
			{
				if (blocksize[j]>=process_size[i])
				{
					allocation[i]=j;
					blocksize[j]-=process_size[i];
					break;
				}
			}
		}
		System.out.println("\nPno.\t\tPsize\t\tblockno");
		for(int i=0;i<n;i++)
		{System.out.print (" " + (i + 1) + "\t\t" + process_size[i] + "\t\t");
		if (allocation[i] != -1)
			  System.out.print (allocation[i] + 1);
			else
			  System.out.print ("Not Allocated");
			System.out.println ();}
	}
	public static void NextFit(int blockSize[], int m, int processSize[], int n) {
		int allocation[] = new int[n], j = 0;
		Arrays.fill(allocation, -1);
		for (int i = 0; i < n; i++) {
			int count = 0;
			while (j < m) {
				count++; 
				if (blockSize[j] >= processSize[i]) {
					allocation[i] = j;
					blockSize[j] -= processSize[i];
					break;
				}
				j = (j + 1) % m;
			}
		}
		System.out.print("\nPNo.       \\tPSize\\t Block no.\n");
		for (int i = 0; i < n; i++) {
			System.out.print( (i + 1) + "\t\t" + processSize[i] + "\t\t");
			if (allocation[i] != -1) {
				System.out.print(allocation[i] + 1);
			} else {
				System.out.print("Not Allocated");
			}
			System.out.println("");
		}
	}

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMemory Allocation Techniques:");
            System.out.println("1. First Fit");
            System.out.println("2. Next Fit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nFIRST FIT MEMORY ALLOCATION\n");
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

                    firstFit(blocksize, m, process_size, n);
                    break;

                case 2:
                    System.out.println("\nNEXT FIT MEMORY ALLOCATION\n");
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

                    NextFit(blockSizeNext, mNext, processSizeNext, nNext);
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