import java.util.Scanner;

public class AverageOfAnyNumberOfIntegersPassed {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = input.nextInt();

        int[] numbers = new int[n];
        for(int a = 0; a < n; a++){
            System.out.println("Enter an integer:");
            numbers[a] = input.nextInt();
        }

        System.out.println("The average of all integers is: " + average(numbers));
    }

    static int average(int... numbers) {
        if(numbers.length == 0)
            return 0;
        int count = 0;
        int sum = 0;
        for(int n : numbers){
            sum += n;
            count++;
        }
        return sum/count;

    }
}
