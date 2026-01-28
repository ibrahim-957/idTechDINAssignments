import java.util.Comparator;
import java.util.List;

public class SortNumbersInDescendingOrder {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 1, 7, 2);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sortedNumbers);
    }
}
