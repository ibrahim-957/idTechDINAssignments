package getCurrentDateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDate);
        System.out.println(currentTime);
        System.out.println(currentDateTime);
    }
}
