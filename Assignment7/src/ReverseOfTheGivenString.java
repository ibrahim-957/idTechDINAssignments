import java.util.Scanner;

public class ReverseOfTheGivenString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String reverse = reverseString(str);
        System.out.println("Reversed string is: " + reverse);
    }

    static String reverseString(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return String.valueOf(arr);
    }
}
