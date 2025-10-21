import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        printTable(a);
    }
    static void printTable(int n){
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " multiplication of " + i + " = " + n * i);
        }
    }
}
