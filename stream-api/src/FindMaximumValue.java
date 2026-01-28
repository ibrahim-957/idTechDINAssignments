import java.util.List;

public class FindMaximumValue {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 50, 30);

        int max  = numbers.stream().max(Integer::compareTo).get();
        System.out.println(max);
    }
}
