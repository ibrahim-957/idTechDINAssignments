import java.util.List;

public class CountElementsGreaterThanTen {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5,10,15,20);

        long count = nums.stream()
                .filter(num -> (num > 10))
                .count();
        System.out.println(count);
    }
}
