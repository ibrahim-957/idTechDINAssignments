import java.util.List;

public class SkipFirstTwoElements {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        numbers.stream()
                .skip(2)
                .forEach(System.out::println);
    }
}
