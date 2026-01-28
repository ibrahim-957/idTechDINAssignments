import java.util.List;

public class ConvertStringsToUppercase {
    public static void main(String[] args) {
        List<String> names = List.of("java", "stream", "api");
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(uppercaseNames);
    }
}
