package basicEnum;

public class Main {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
        findDayIsAWeekendOrWeekday(day);
    }

    public static void findDayIsAWeekendOrWeekday(Day day){
        if (day == Day.SATURDAY || day == Day.SUNDAY){
            System.out.println("WEEKEND");
        }
        else{
            System.out.println("WEEKDAY");
        }
    }
}
