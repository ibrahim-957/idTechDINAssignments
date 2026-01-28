import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElements {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 3, 5);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicate = numbers.stream()
                .filter(n ->!seen.add(n))
                .collect(Collectors.toSet());

        System.out.println("Duplicate elements: " + duplicate);
    }
}
