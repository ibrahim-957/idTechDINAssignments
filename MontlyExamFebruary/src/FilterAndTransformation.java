import java.util.Comparator;
import java.util.List;

public class FilterAndTransformation {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 10, 15, 20, 7, 8);

        List<Integer> processedNums = nums.stream()
                .filter(num -> num % 2 != 0)
                .map(numb -> numb *3)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(processedNums);
    }
}
