import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsByLength {
    public static void main(String[] args) {
        List<String> words = List.of("a", "bb", "ccc", "dd");

        Map<Integer, List<String>> map = words.stream()
                .collect(Collectors.groupingBy(word -> word.length()));

        System.out.println(map);
    }
}
