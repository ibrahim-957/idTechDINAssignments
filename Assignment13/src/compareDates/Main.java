package compareDates;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate summerSolstice = LocalDate.of(2025, 6, 21);

        System.out.println("Current date is before Summer Solstice: " + currentDate.isBefore(summerSolstice));
        System.out.println("Current date is after Summer Solstice: " + currentDate.isAfter(summerSolstice));
        System.out.println("Current date is Summer Solstice: " + currentDate.isEqual(summerSolstice));
    }
}
