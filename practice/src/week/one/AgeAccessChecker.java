package week.one;

import java.util.Scanner;

public class AgeAccessChecker {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter your age: ");
            int age = input.nextInt();

            boolean isAdult = age >= 18;

            if (isAdult){
                System.out.println("Access granted");
            } else  {
                System.out.println("Access denied");
            }
        }
    }
}
