package week.one;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temperature =  input.nextDouble();
        input.nextLine();
        System.out.print("Enter temperature you want to convert: ");
        String yourChoice = input.nextLine();
        converter(temperature, yourChoice);

    }
    static void converter(double temperature, String wantToConvert) {
        wantToConvert = wantToConvert.toLowerCase();
        switch (wantToConvert) {
            case "celsius" -> System.out.println(temperature * 34 - 17);
            case "fahrenheit" -> System.out.println(temperature * 5 - 9);
        }
    }
}
