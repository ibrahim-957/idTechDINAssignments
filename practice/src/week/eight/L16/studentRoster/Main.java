package week.eight.L16.studentRoster;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> roster = new ArrayList<>();
        roster.add("Charlie");
        roster.add("Alice");
        roster.add("Eve");
        roster.add("Bob");
        roster.add("Diana");

        System.out.println("=== Initial Roster ===");
        System.out.println("Size: " + roster.size());
        System.out.println(roster);

        System.out.println("\nContains 'Alice': " + roster.contains("Alice"));
        roster.remove("Eve");
        System.out.println("After removing Eve: " + roster);

        sortRoster(roster);
        System.out.println("\n=== Sorted Roster ===");
        System.out.println(roster);

        System.out.println("\n=== Binary Search ===");
        int idx = binarySearch(roster, "Diana");
        System.out.println("Search 'Diana': index " + idx);
        System.out.println("Search 'Zara': index " + binarySearch(roster, "Zara"));

        LinkedList<String> waitlist = new LinkedList<>();
        waitlist.addLast("Frank");
        waitlist.addLast("Grace");
        waitlist.addLast("Henry");
        waitlist.addLast("Iris");
        waitlist.addLast("Jack");

        System.out.println("\n=== Waitlist ===");
        System.out.println(waitlist);

        System.out.println("\nRoster size BEFORE transfer: " + roster.size());

        System.out.println("\n=== Transferring 3 from Waitlist ===");
        transferFromWaitlist(waitlist, roster, 3);

        System.out.println("\nRoster size AFTER transfer: " + roster.size());

        System.out.println("\n=== Final Roster ===");
        sortRoster(roster);
        System.out.println(roster);

        System.out.println("\n=== Remaining Waitlist ===");
        System.out.println(waitlist);
    }


    public static void sortRoster(ArrayList<String> list) {
        int n =  list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

    }

    public static int binarySearch(ArrayList<String> list, String search) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = list.get(mid).compareTo(search);
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void transferFromWaitlist(
            LinkedList<String> waitlist, ArrayList<String> roster, int count) {

        for (int i = 0; i < count; i++) {
            if (!waitlist.isEmpty()) {
                String student = waitlist.removeFirst();
                roster.add(student);
                System.out.println("Enrolled: " + student);
            }
        }
    }

    /*
     * ArrayList memory:
     * - Stores elements in a contiguous array internally
     * - Each element: just the object reference (8 bytes)
     * - Allocates extra capacity upfront (default 10, grows by 50%)
     * - When full, creates a NEW bigger array and copies everything
     * - Less memory per element but wastes space from unused capacity
     *
     * LinkedList memory:
     * - Each element wrapped in a Node object
     * - Each Node stores: the data + pointer to next + pointer to previous
     * - No wasted capacity — only allocates what it uses
     * - But each element costs significantly more memory per node
     * - For 1000 strings: LinkedList uses roughly 3x more memory than ArrayList
     *
     * Conclusion:
     * - For large lists where memory matters → ArrayList
     * - For frequent add/remove at ends → LinkedList is fine despite memory cost
     */
}
