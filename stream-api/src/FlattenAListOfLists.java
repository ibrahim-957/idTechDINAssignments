import java.util.List;

public class FlattenAListOfLists {
    public static void main(String[] args) {
        List<List<String>> list = List.of(
                List.of("A", "B"),
                List.of("C", "D")
        );

        List<String> flattenList = list.stream()
                .flatMap(flatten -> flatten.stream())
                .toList();

        System.out.println(flattenList);
    }
}
