import java.util.List;

public class MultiplyEachNumberByTwo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3);

        List<Double> multiply = numbers.stream()
                .map(num -> Math.pow(num,2))
                .toList();
        System.out.println(multiply);
    }
}
