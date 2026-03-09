package week.three;

import java.util.HashMap;
import java.util.Map;

public class CountOfCharacterFromWord {
    public static void main(String[] args) {
        String str = "banana";
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
