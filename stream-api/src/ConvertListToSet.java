import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertListToSet {
    public static void main(String[] args) {
        List<String> names = List.of("A","B","A");

        Set<String> set = names.stream()
                .collect(Collectors.toSet());
        System.out.println(set);
    }
}
