import java.util.List;

public class FindLengthOfEachString {
    public static void main(String[] args) {
        List<String> words = List.of("java", "stream");

        words.stream()
                .map(String::length)
                .forEach(System.out::println);
    }
}
