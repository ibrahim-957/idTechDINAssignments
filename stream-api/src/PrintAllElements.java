import java.util.List;

public class PrintAllElements {
    public static void main(String[] args) {
        List<String> names = List.of("A", "B", "C");

        names.stream().forEach(System.out::println);
    }
}
