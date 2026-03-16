package week.seven.l14.meetingScheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Meeting {
    private String title;
    private LocalDate date;
    private LocalTime time;
    private LocalDateTime dateTime;

    public Meeting(String title, LocalDate date, LocalTime time) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.dateTime = LocalDateTime.of(date, time);
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isInPast() {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public long daysUntil(LocalDate other){
        return ChronoUnit.DAYS.between(this.date, other);
    }
}
