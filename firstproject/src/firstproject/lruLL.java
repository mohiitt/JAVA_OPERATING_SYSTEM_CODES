package firstproject;
import java.util.LinkedList;
import java.util.Scanner;

public class lruLL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of page references: ");
        int numReferences = scanner.nextInt();

        int[] referenceString = new int[numReferences];

        System.out.println("Enter the page references:");

        for (int i = 0; i < numReferences; i++) {
            referenceString[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of frames: ");
        int frameCount = scanner.nextInt();

        LinkedList<Integer> frameList = new LinkedList<>();
        int pageFaults = 0;
        int hits=0;

        System.out.println("\nLRU Page Replacement Algorithm");

        for (int page : referenceString) {
            System.out.print("Page " + page + ": ");
            if (!frameList.contains(page)) {
                if (frameList.size() == frameCount) {
                    int removedPage = frameList.removeFirst();
                    System.out.println("Page " + removedPage + " removed from frames.");
                }
                frameList.add(page);
                pageFaults++;
                System.out.println("Page " + page + " added to frames.");
            } else {
                frameList.removeFirstOccurrence(page);
                frameList.add(page);
                System.out.println("Page " + page + " already in frames. Updated position.");
                hits++;
            }

            System.out.println("Current Frame List: " + frameList);
        }

        System.out.println("\nFinal Frame List: " + frameList);
        System.out.println("Page Faults: " + pageFaults);
        System.out.println("Hits : "+ hits);
    }
}
