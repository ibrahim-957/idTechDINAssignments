import java.util.List;

public class SquareAndSortNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 1, 4, 2);

        List<Integer> squareNumbers = numbers.stream()
                .map(num -> (int) Math.pow(num, 2))
                .sorted()
                .toList();
        System.out.println(squareNumbers);
    }
}
