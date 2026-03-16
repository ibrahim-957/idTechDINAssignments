package week.seven.l14.meetingScheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        var meeting1 = new Meeting("Team Standup",
                LocalDate.of(2024, 3, 20),
                LocalTime.of(9, 0));
        var meeting2 = new Meeting("Project Review",
                LocalDate.of(2024, 3, 18),
                LocalTime.of(14, 30)
        );
        var meeting3 = new Meeting("Client Call",
                LocalDate.of(2024, 3, 25),
                LocalTime.of(11, 0)
        );

        var meetings = new ArrayList<Meeting>();
        meetings.add(meeting1);
        meetings.add(meeting2);
        meetings.add(meeting3);

        meetings.sort(Comparator.comparing(Meeting::getDateTime));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("======= MEETING SCHEDULE =======");
        for (Meeting meeting : meetings) {
            System.out.printf("%-20s %s  |  Past: %s%n",
                    meeting.getTitle(),
                    meeting.getDateTime().format(formatter),
                    meeting.isInPast() ? "yes" : "no"
                    );
        }

        System.out.println();
        Meeting first = meetings.getFirst();
        Meeting last = meetings.getLast();
        long daysBetween = first.daysUntil(last.getDate());
        System.out.println("Days between first and last meeting: " + daysBetween);
    }
}
