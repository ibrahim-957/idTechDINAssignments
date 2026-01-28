import java.util.List;

public class FindTheFirstElementStartingWithA {
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Alice", "Andrew", "Charlie");

        List<String> startWithA = names.stream()
                .filter(value -> value.startsWith("A"))
                .toList();
        System.out.println(startWithA);
    }
}
