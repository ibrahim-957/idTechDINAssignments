import java.util.List;

public class FindFirstElement {
    public static void main(String[] args) {
        List<String> names = List.of("Java", "Python", "C++");

        names.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }
}
