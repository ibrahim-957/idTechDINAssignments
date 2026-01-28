import java.util.List;

public class FindMinimumNumber {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(9, 3, 6);
        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);
    }
}
