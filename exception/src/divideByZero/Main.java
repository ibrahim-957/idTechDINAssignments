package divideByZero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double num1 = input.nextInt();
            System.out.print("Enter a number: ");
            double num2 = input.nextInt();
            double result = num1 / num2;
            System.out.println(result);
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }
        finally {
            input.close();
        }
    }
}
