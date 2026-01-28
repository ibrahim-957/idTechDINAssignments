import java.util.List;

public class CheckIfAnyNumberIsEven {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 5, 6);

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }
}
