import java.util.List;
import java.util.stream.Collectors;

public class JoinStringsWithComma {
    public static void main(String[] args) {
        List<String> words = List.of("A", "B", "C");
        String result = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
