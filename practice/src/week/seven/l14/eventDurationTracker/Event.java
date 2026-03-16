package week.seven.l14.eventDurationTracker;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    public Event(String name, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Duration getDuration() {
        return Duration.between(start, end);
    }

    public String getDurationFormatted() {
        Duration duration = getDuration();
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return hours + "h " + minutes + "m";
    }

    public boolean isOngoing() {
        LocalDateTime now = LocalDateTime.now();
        return  now.isAfter(start) && now.isBefore(end);
    }

    /*
     * java.util.Date (Java 1.0):
     * - Mutable and not thread safe
     * - Stores date + time + timezone all mixed together
     * - Months are 0-based (January = 0)
     * - Most methods deprecated since Java 8
     * - Still used in legacy code and some frameworks
     * - Example: new Date() → current date and time
     *
     * java.sql.Date (extends java.util.Date):
     * - Designed specifically for SQL database interaction
     * - Strips the time part — only stores date
     * - Used with JDBC: ResultSet.getDate(), PreparedStatement.setDate()
     * - Also mutable and considered legacy
     * - Example: new java.sql.Date(System.currentTimeMillis())
     *
     * LocalDate (Java 8+):
     * - Immutable and thread safe
     * - Only stores date — no time, no timezone
     * - Months are 1-based (January = 1)
     * - Clean modern API: now(), of(), plusDays(), isBefore()
     * - Example: LocalDate.of(2024, 3, 15)
     *
     * Rule: use LocalDate/LocalDateTime for all new code
     *       use java.sql.Date only when working with JDBC directly
     *       avoid java.util.Date entirely in new projects
     */
}
