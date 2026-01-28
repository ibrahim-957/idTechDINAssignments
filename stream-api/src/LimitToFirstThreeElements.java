import java.util.List;

public class LimitToFirstThreeElements {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);

        numbers.stream()
                .limit(3)
                .forEach(System.out::println);
    }
}
