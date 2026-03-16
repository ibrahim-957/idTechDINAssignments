package week.seven.l14.eventDurationTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        var past = new Event("Morning Workshop",
                now.minusHours(5),
                now.minusHours(2)
        );

        var ongoing = new Event("Afternoon Conference",
                now.minusHours(1),
                now.plusHours(2)
        );

        var future = new Event("Evening Seminar",
                now.plusHours(3),
                now.plusHours(7).plusMinutes(30)
        );

        var events = new ArrayList<Event>();
        events.add(past);
        events.add(ongoing);
        events.add(future);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("======= EVENT SCHEDULE =======");
        for (Event e : events) {
            System.out.println("\nEvent    : " + e.getName());
            System.out.println("Start    : " + e.getStart().format(formatter));
            System.out.println("End      : " + e.getEnd().format(formatter));
            System.out.println("Duration : " + e.getDurationFormatted());
            System.out.println("Ongoing  : " + e.isOngoing());
        }

        System.out.println("\n======= LONGEST EVENT =======");
        Event longest = events.get(0);
        for (Event e : events) {
            if (e.getDuration().compareTo(longest.getDuration()) > 0) {
                longest = e;
            }
        }
        System.out.println("Longest: " + longest.getName());
        System.out.println("Duration: " + longest.getDurationFormatted());
    }
}
