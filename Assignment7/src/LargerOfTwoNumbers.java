import java.util.Scanner;

public class LargerOfTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        int result = max(a, b);
        System.out.println("The largest number is " + result);
    }
    public static int max(int a, int b) {
        return Math.max(a, b);
    }
}
