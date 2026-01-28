import java.util.List;

public class ConvertIntegerListToStringList {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);

        List<String> stringNumbers = numbers.stream()
                .map(String::valueOf)
                .toList();
        stringNumbers.forEach(System.out::println);
    }
}
