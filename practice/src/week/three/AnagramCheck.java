package week.three;

import java.util.Arrays;

public class AnagramCheck {

    static boolean areAnagrams(String s1, String s2) {

        s1 = s1.toLowerCase().replaceAll("\\s+", "");
        s2 = s2.toLowerCase().replaceAll("\\s+", "");

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }

    public static void main(String[] args) {

        System.out.println(areAnagrams("listen", "silent"));
        System.out.println(areAnagrams("Dormitory", "Dirty room"));
        System.out.println(areAnagrams("hello", "world"));
    }
}
