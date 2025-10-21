import java.util.Scanner;

public class StringIsAPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        if (isPalindrome(str)) {
            System.out.println("The string is palindrome");
        }
        else  {
            System.out.println("The string is not palindrome");
        }

    }

    static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        String reverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(reverseStr);
    }
}
