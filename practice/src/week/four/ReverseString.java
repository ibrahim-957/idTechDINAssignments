package week.four;

import static java.lang.System.*;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Java";
        out.println(reverse(str));
    }
    static String reverse(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length()/2; i++) {
            char temp = arr[i];
            arr[i] = arr[s.length() - i - 1];
            arr[s.length() - i - 1] = temp;
        }
        return String.valueOf(arr);
    }
}
