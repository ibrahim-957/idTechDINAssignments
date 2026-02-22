import java.util.List;

public class StreamApiSimpleTask {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        List<Integer> processedNums = nums.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num *2)
                .toList();
        System.out.println(processedNums);
    }
}
