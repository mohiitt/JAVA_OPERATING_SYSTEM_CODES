package firstproject;
import java.util.*;
public class fifo {
	private Scanner sc;
	public void execute() {
		sc = new Scanner(System.in);
		System.out.println("Enter Number of Pages:");
		int numPages = sc.nextInt();
		int pages[] = new int[numPages];
		System.out.println("Enter Reference String: ");
		for (int i = 0; i < numPages; i++) {
			pages[i] = sc.nextInt();
		}
		System.out.println("Enter Number of Frames :");
		int capacity = sc.nextInt();

		// To represent set of current pages
		HashSet<Integer> frames = new HashSet<>(capacity);
		// To store pages in FIFO manner
		Queue<Integer> index = new LinkedList<>();
		int pageFaults = 0;
		int hits = 0;
		System.out.println("\n----- FIFO ------\n ");
		System.out.println("incoming \t pages");
		for (int i = 0; i < numPages; i++) {
			if (frames.size() < capacity) {
				if (!frames.contains(pages[i])) {
					frames.add(pages[i]);
					index.add(pages[i]);
					pageFaults++;

				} 
				else {
					hits++;
				}
			} else {
				if (!frames.contains(pages[i])) 
				{
					int val = index.peek();
					index.poll();
					frames.remove(val);
					frames.add(pages[i]);
					index.add(pages[i]);
					pageFaults++;

				} else {
					hits++;
				}
			}
			System.out.print(pages[i] + "\t\t");
			System.out.print(index + " \n");
		}
		System.out.println("\nNumber of Page Faults : " + pageFaults);
		System.out.println("\nHits : " + hits);
	}

	public static void main(String[] args) {
		fifo fifo1 = new fifo();
		fifo1.execute();
	}
}
