import java.util.Scanner;

public class NumberOfVowelsInTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int result = countVowels(str);
        System.out.println("The number of vowels in the String is: " + result);
    }

    static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        char[] arr = str.toCharArray();
        char[] vowelsArr = vowels.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (char c : vowelsArr) {
                if (str.charAt(i) == c) {
                    count++;
                }
            }
        }
        return count;
    }
}
