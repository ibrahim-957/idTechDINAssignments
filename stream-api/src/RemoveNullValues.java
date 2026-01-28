import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveNullValues {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("A", null, "B", null, "C");

        List<String> notNullData = data.stream()
                        .filter(value -> Objects.nonNull(value))
                                .toList();
        System.out.println(notNullData);
    }
}
