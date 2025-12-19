package createSpecificDates;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate myBirthday = LocalDate.of(2002, 5, 6);

        LocalDate firstDayOfNewCentury = LocalDate.of(2000, 1, 1);

        System.out.println("My birthday: " + myBirthday);
        System.out.println("First day of new century: " + firstDayOfNewCentury);
    }
}
