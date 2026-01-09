package customException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        if (age < 18)
            throw  new InvalidAgeException("Minimum age is 18");
    }
}
