import java.util.List;

public class SortStringsAlphabetically {
    public static void main(String[] args) {
        List<String> names = List.of("Banana", "Apple", "Mango");

        List<String> sortedNames = names.stream()
                .sorted()
                .toList();

        System.out.println(sortedNames);
    }
}
