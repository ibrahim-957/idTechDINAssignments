import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1.
        /*for (int i = 1; i <=10 ; i++) {
            System.out.println(i);
        }*/

        Scanner sc = new Scanner(System.in);

        // 2.
        /*
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);*/

        // 3.
        /*for (int i = 1; i <=50 ; i++) {
            if(i%2==0){
                System.out.println(i);
            }
        }*/

        // 4.
        /*int j = 10;
        while (j > 0) {
            System.out.println(j--);
        }*/

        // 5.
        /*System.out.print("Enter the number: ");
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            int multiplier = num * i;
            System.out.println(num + " * " + i + " = " + multiplier);
        }*/

        // 6.
        /*System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 2; i <= num; i+=2) {
            sumEven += i;
        }
        for (int i = 1; i <= num; i+=2) {
            sumOdd += i;
        }
        System.out.println("Sum of odd: " + sumOdd);
        System.out.println("Sum of even: " + sumEven);*/

        // 7.
        /*System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println(factorial);*/

        // 8.
        /*System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int revNum;
        int reminder = 0;
        while (num > 0) {
            revNum = num % 10;
            reminder = (reminder * 10) + revNum;
            num = num / 10;
        }
        System.out.println("Reversed number: " + reminder);*/

        // 9.
        /*System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int sum = 0;
        int revNum;
        while(num > 0){
            revNum = num % 10;
            sum = sum + revNum;
            num = num / 10;
        }
        System.out.println("The sum is " + sum);*/

        // 10.
        /*System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int count = 0;
        if (num <= 1) {
            System.out.println(num + " is not Prime Number");
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    count++;
                    break;
                }
            }
            if (count > 0) {
                System.out.println(num + " is not Prime Number");
            } else {
                System.out.println(num + " is Prime Number");
            }
        }*/

        // 11.
        /*System.out.print("Enter the character you want: ");
        char ch = sc.next().charAt(0);
        System.out.print("Enter the layer count you want: ");
        int layer = sc.nextInt();
        for (int i = 1; i <= layer; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }*/
    }
}