import java.util.List;

public class CountTotalElements {
    public static void main(String[] args) {
        List<String> items = List.of("pen", "pencil", "eraser");

        long count = items.stream()
                .count();
        System.out.println(count);
    }
}
