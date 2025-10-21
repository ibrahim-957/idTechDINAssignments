import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        addTwoNumbers(a, b);
    }
    static void addTwoNumbers(int a, int b)
    {
        int sum = a + b;
        System.out.println("The sum is " + sum);
    }
}
