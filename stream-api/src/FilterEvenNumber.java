import java.util.List;

public class FilterEvenNumber {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        System.out.println(evenNumbers);
    }
}
