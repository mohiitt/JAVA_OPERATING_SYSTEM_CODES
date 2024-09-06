package firstproject;
import java.util.Arrays;
import java.util.Scanner;
public class nxfit {
	static void NextFit(int blockSize[], int m, int processSize[], int n) {
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
		System.out.print("\"\\nPNo.       \\tPSize\\t Block no.\"");
		for (int i = 0; i < n; i++) {
			System.out.print(i + 1 + "\t\t" + processSize[i] + "\t\t");
			if (allocation[i] != -1) {
				System.out.print(allocation[i] + 1);
			} else {
				System.out.print("Not Allocated");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		System.out.print("\n Next Fit Memory Allocation \n");
		int m;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of block size ");
		m = sc.nextInt();
		int[] blockSize = new int[10];
		System.out.println("Enter the block size : ");
		for (int i = 0; i < m; i++) {
			blockSize[i] = sc.nextInt();
		}
		int n;
		System.out.print("Enter the number of process size ");
		n = sc.nextInt();
		int[] processSize = new int[10];
		System.out.println("Enter the process size : ");
		for (int i = 0; i < n; i++) {
			processSize[i] = sc.nextInt();
		}
		NextFit(blockSize, m, processSize, n);
	}
}
