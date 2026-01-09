package inputValidation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = input.nextInt();
        if(age > 120 || age < 0) {
            throw  new InputMismatchException("Invalid age");
        }
    }
}
