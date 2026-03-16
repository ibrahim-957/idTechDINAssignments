package week.eight.L16.taskManager;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Write report");
        tasks.add("Send email");
        tasks.add("Fix bug");
        tasks.add("Review PR");
        tasks.add("Update docs");
        tasks.add("Fix bug");
        tasks.add("Write report");

        System.out.println("=== All Tasks ===");
        for (String task : tasks) {
            System.out.println("- " + task);
        }

        tasks.remove("Send email");
        tasks.remove("Write report");

        System.out.println("\n=== Remaining Tasks ===");
        for (String task : tasks) {
            System.out.println("- " + task);
        }

        System.out.println("\n=== Duplicates Found ===");
        ArrayList<String> dupes = findDuplicates(tasks);
        if (dupes.isEmpty()) {
            System.out.println("No duplicates");
        } else {
            for (String d : dupes) {
                System.out.println("Duplicate: " + d);
            }
        }

        System.out.println("\n=== Pending Queue ===");
        LinkedList<String> pending = new LinkedList<>();
        pending.offer("Fix bug");
        pending.offer("Review PR");
        pending.offer("Update docs");

        System.out.println("Queue: " + pending);
        System.out.println("Peek (front): " + pending.peek());

        System.out.println("\nProcessing tasks:");
        while (!pending.isEmpty()) {
            String task = pending.poll();
            System.out.println("Done: " + task);
            System.out.println("Remaining queue: " + pending);
        }
    }

    public static ArrayList<String> findDuplicates(ArrayList<String> list) {
        ArrayList<String> duplicates = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))
                        && !duplicates.contains(list.get(i))) {
                    duplicates.add(list.get(i));
                }
            }
        }

        return duplicates;
    }

}
