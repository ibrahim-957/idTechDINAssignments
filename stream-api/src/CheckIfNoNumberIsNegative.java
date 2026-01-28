import java.util.List;

public class CheckIfNoNumberIsNegative {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3);

        boolean noNegative = numbers.stream()
                .noneMatch(number -> number < 0);
        System.out.println(noNegative);
    }
}
