import java.util.List;

public class CheckIfAllNumbersArePositive {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, -1);
        numbers.stream()
                .filter(num -> num > 0)
                .forEach(System.out::println);
    }
}
