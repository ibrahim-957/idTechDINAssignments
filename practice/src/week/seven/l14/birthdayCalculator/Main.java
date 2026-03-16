package week.seven.l14.birthdayCalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

        var dates = new ArrayList<LocalDate>();
        dates.add(LocalDate.of(1995, 6, 15));
        dates.add(LocalDate.of(2000, 12, 31));
        dates.add(LocalDate.of(2027, 3, 10));

        System.out.println("======= BIRTHDAY CALCULATOR =======");

        for (LocalDate birthDate : dates) {
            System.out.println("\nBirthdate: " + birthDate.format(formatter));

            int age = calculateAge(birthDate);
            System.out.println("Age: " + (age > 0 ? age + " years" : "Not born yet"));

            long days = daysUntilNextBirthday(birthDate);
            System.out.println("Days until next birthday: " + days);

            boolean leap = isLeapYear(birthDate.getYear());
            System.out.println("Born in leap year: " + leap);
        }

        System.out.println("\n======= NEXT FRIDAY THE 13TH =======");
        LocalDate nextFriday13 = getNextFriday13th();
        System.out.println("Next Friday 13th: " + nextFriday13.format(formatter));

        long daysUntil = ChronoUnit.DAYS.between(LocalDate.now(), nextFriday13);
        System.out.println("Days away: " + daysUntil);
    }

    public static int calculateAge(LocalDate birthday) {
        Period period = Period.between(birthday, LocalDate.now());
        return period.getYears();
    }

    public static long daysUntilNextBirthday(LocalDate birthday) {
        LocalDate today = LocalDate.now();

        LocalDate nextBirthday = birthday.withYear(today.getYear());

        if (!nextBirthday.isAfter(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        return ChronoUnit.DAYS.between(today, nextBirthday);
    }

    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    public static LocalDate getNextFriday13th(){
        LocalDate date = LocalDate.now().withDayOfMonth(1);

        while (true){
            LocalDate the13th = date.withDayOfMonth(13);
            if (the13th.getDayOfWeek() == DayOfWeek.FRIDAY
            && the13th.isAfter(LocalDate.now())) {
                return the13th;
            }
            date = date.plusMonths(1);
        }
    }
}
