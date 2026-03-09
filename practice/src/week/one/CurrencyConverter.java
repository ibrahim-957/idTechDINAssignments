package week.one;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an amount in dollars: ");
        double amount = input.nextDouble();
        input.nextLine();
        System.out.print("Enter a currency code: ");
        String code = input.nextLine();
        convert(amount, code);
        input.close();
    }

    static  void convert(double money, String currency) {
        switch (currency) {
            case "AZN" -> System.out.println(money * 1.7);
            case "BRL" -> System.out.println(money * 1.9);
            case "CAD" -> System.out.println(money * 1.10);
        }
    }
}
