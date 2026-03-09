package week.one;

import java.util.Scanner;

public class FindMaximumFromThreeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = input.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = input.nextInt();
        System.out.println("Enter the third number: ");
        int num3 = input.nextInt();
        if (num1 > num2){
            if (num1 > num3){
                System.out.println(num1 + " is greater than " + num3 + " and " + num2);
            } else {
                System.out.println(num3 + " is greater than " + num1 + " and " + num2);
            }
        } else {
            if (num2 > num3){
                System.out.println(num2 + " is greater than " + num1 + " and " + num3);
            } else {
                System.out.println(num3 + " is greater than " + num2 + " and " + num1);
            }
        }

        input.close();
    }
}
