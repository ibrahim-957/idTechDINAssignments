import java.util.List;

public class CheckIfListIsEmptyUsingStream {
    public static void main(String[] args) {
        List<String> list = List.of();

        boolean empty = list.stream().allMatch(String::isEmpty);
        System.out.println(empty);
    }
}
