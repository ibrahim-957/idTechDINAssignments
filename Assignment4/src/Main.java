import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*// 1.
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        String type = num % 2 == 0 ? "even" : "odd";
        System.out.println("The number is: " + type);

        sc.nextLine();
        System.out.println("-----------------------------");*/

        /*// 2.
        System.out.print("Enter the number: ");
        int num2 = sc.nextInt();
        if (num2 > 0){
            System.out.println("The number is positive");
        }
        else if (num2 < 0){
            System.out.println("The number is negative");
        }
        else{
            System.out.println("The number is zero");
        }
        sc.nextLine();
        System.out.println("-----------------------------");*/

        /*// 3.
        System.out.print("Enter the first number: ");
        int num3 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int num4 = sc.nextInt();
        if (num3 > num4){
            System.out.println(num3 + " is larger than " + num4);
        }
        else if (num3 < num4){
            System.out.println(num4 + " is larger than " + num3);
        }
        else{
            System.out.println(num3 + " is equal " + num4);
        }

        sc.nextLine();
        System.out.println("-----------------------------");*/

        /*// 4.
        System.out.print("Enter the grade: ");
        int grade = sc.nextInt();
        if (grade >= 0 && grade <= 100){
            if(grade >= 50){
                System.out.println("Student pass with " + grade + " grade.");
            }
            else {
                System.out.println("Student fail with " + grade + " grade.");
            }
        }
        else {
            System.out.println("Grade must be between 0 and 100.");
        }
        sc.nextLine();
        System.out.println("-----------------------------");
        */

        /*// 5.
        System.out.print("Enter the letter: ");
        char letter = sc.next().charAt(0);
        switch (letter) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
                System.out.println(letter + " is a vowel");
                break;
            default:
                System.out.println(letter + " is Consonant");
        }
        sc.nextLine();
        System.out.println("-----------------------------");
        */

        /*// 6.
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("The year is a leap year");
        }
        else {
            System.out.println("The year is not a leap year");
        }
        sc.nextLine();
        System.out.println("-----------------------------");*/

        /*// 7.
        System.out.print("Enter the grade: ");
        int grade = sc.nextInt();
        if (grade >= 0 && grade <= 100) {
            if (grade >=90) {
                System.out.println("A");
            }
            else if (grade >=80) {
                System.out.println("B");
            }
            else if (grade >=70) {
                System.out.println("C");
            }
            else if (grade >=60) {
                System.out.println("D");
            }
            else {
                System.out.println("F");
            }
        }
        else {
            System.out.println("Grade must be between 0 and 100");
        }
        sc.nextLine();
        System.out.println("-----------------------------");*/

        /*// 8.
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.print("Enter third number: ");
        int c = sc.nextInt();
        if (a >b && a > c) {
            System.out.println(a + " is greater than " + b + " and " + c);
        }
        else if (b > a && b > c) {
            System.out.println(b + " is greater than " + a + " and " + c);
        }
        else {
            System.out.println(c + " is greater than " + a + " and " + b);
        }
        sc.nextLine();
        System.out.println("-----------------------------");*/

        /*// 9.
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        System.out.print("Enter one of these four operators(+ - * /): ");
        char operator = sc.next().charAt(0);
        switch (operator) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
        }
        sc.nextLine();
        System.out.println("-----------------------------");*/

        /*// 10.
        System.out.print("Enter the day of the week: ");
        int day = sc.nextInt();
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("There are only 7 days in a week.");
                break;

        }
        sc.nextLine();
        System.out.println("-----------------------------");*/

        /*// 11.
        System.out.print("Enter the purchase amount: ");
        int amount = sc.nextInt();
        if (amount >=1000) {
            System.out.println("you have 20% discount");
        }
        else if (amount >=500) {
            System.out.println("you have 10% discount");
        }
        else {
            System.out.println("you haven't discount");
        }*/
    }
}