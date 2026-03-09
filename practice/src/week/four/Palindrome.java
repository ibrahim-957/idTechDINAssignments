package week.four;

public class Palindrome {
    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome(str));
    }
    static boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
