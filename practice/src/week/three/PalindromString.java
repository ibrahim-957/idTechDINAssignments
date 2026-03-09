package week.three;

public class PalindromString {
    public static void main(String[] args) {
        String str = "Level";

        String normalized = str.toLowerCase();

        String reversed = new StringBuilder(normalized)
                .reverse()
                .toString();

        System.out.println("Palindrome: " + normalized.equals(reversed));
    }
}
