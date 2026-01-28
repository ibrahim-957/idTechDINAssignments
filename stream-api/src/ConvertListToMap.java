import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "kiwi");

        Map<String , Integer> map = words.stream()
                .collect(Collectors.toMap(word -> word, word -> word.length()));
        System.out.println(map);
    }
}
