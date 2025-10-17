import java.util.Scanner;

public class SumOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want in the array: ");
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];
        int sum = 0;
        for(int i = 0; i < arraySize; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
        for(int value : arr){
            sum += value;
        }
        System.out.println("The sum of the elements is: " + sum);
        sc.close();
    }
}
