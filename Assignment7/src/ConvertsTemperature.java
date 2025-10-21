import java.util.Scanner;

public class ConvertsTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double temperature = sc.nextDouble();
        System.out.println("The temperature in Fahrenheit is " + celsiusToFahrenheit(temperature));
    }

    static double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }
}
