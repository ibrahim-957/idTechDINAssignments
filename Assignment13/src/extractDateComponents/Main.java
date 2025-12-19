package extractDateComponents;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate.getYear());
        System.out.println(currentDate.getMonth());
        System.out.println(currentDate.getDayOfWeek());
    }
}
