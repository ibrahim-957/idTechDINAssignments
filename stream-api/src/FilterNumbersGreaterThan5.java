import java.util.List;

public class FilterNumbersGreaterThan5 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,4,6,8,2);

        numbers.stream()
                .filter(num -> num>5)
                .forEach(System.out::println);
    }
}
