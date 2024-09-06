package firstproject;
import java.util.*;
public class ffit
{
	public static void firstfit(int blocksize[],int m, int process_size[],int n)
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
	public static void main(String[]args)
	{
		System.out.println("\nFIRST FIT MEMORY ALLOCATION\n");
		Scanner sc=new Scanner(System.in);
	    System.out.print("Enter the number of block size ");
        int m;
	    m=sc.nextInt();
	    int[] blocksize=new int[10];
	    System.out.println("Enter the block size : ");  
        for (int i=0;i<m;i++)
        {
        	blocksize[i]=sc.nextInt();}
        System.out.print("Enter the number of process size ");
        int n;
        n=sc.nextInt();
        int[]process_size=new int [10];
        System.out.println("Enter the process size : ");  
        for(int i=0;i<n;i++)
        {
        	process_size[i]=sc.nextInt();
        	}
        sc.close();
  firstfit(blocksize,m,process_size,n);
	}}