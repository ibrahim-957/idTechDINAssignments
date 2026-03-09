package week.three;

import java.util.ArrayList;
import java.util.List;

public class CustomSplit {
    public static void main(String[] args) {
        String str = "Java-is-very-powerful";
        char ch = '-';
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ch) {
                words.add(currentWord.toString());
                currentWord = new StringBuilder();
            } else  {
                currentWord.append(c);
            }
        }
        words.add(currentWord.toString());
        System.out.println(words);
    }
}
