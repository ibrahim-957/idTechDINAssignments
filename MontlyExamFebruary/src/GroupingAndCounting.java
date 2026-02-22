import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndCounting {
    public static void main(String[] args) {
        List<String> names = List.of("Ali", "Aysel", "Murad", "Nigar", "Amin");

        Map<Character, Long> result = names.stream()
                .collect(Collectors.groupingBy(
                        name -> name.charAt(0),
                        Collectors.counting()
                ));
        System.out.println(result);
    }
}
