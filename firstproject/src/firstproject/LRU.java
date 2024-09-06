package firstproject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class LRU {
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
		System.out.println("Enter Number of Frames:");
		int capacity = sc.nextInt();
//To represent set of current pages
		HashSet<Integer> frames = new HashSet<>(capacity);
//To store LRU Indexes of pages //<key=Page,value=index>
		HashMap<Integer, Integer> index = new HashMap<>();
		int pageFaults = 0;
		int hits = 0;
		System.out.println("\n----- LRU ------\n ");
		for (int i = 0; i < numPages; i++) {
			System.out.println("Page Access: " + pages[i]);
		
			if (frames.size() < capacity) // check if set can hold n=more pages
			{
//IF page not present insert into set and increment pagefault
				if (!frames.contains(pages[i])) {
					frames.add(pages[i]);
					index.put(pages[i], i); // push current page into queue
					pageFaults++;
				} else {
					hits++;
					index.put(pages[i], i);
				}
				
			} else // set is full,need replacement
			{
				if (!frames.contains(pages[i])) // frame is not present present
				{
					int lru = Integer.MAX_VALUE;
					int val = Integer.MIN_VALUE;
					Iterator<Integer> itr = frames.iterator();
					while (itr.hasNext()) {
						int temp = itr.next();
						if (index.get(temp) < lru) {
							lru = index.get(temp);
							val = temp;
						}
					}
					frames.remove(val);
					frames.add(pages[i]);
					pageFaults++;
					index.put(pages[i], i);
				} else // frame is present in set
				{
					hits++;
					index.put(pages[i], i);
					
				}
			}
			frames.forEach(System.out::print);
			System.out.println();
		}
		System.out.println("\nNumber of Page Faults : " + pageFaults);
		System.out.println("\nHits: " + hits);
	}

public static void main(String[] args) {
LRU lru=new LRU();
lru.execute();
}
}

