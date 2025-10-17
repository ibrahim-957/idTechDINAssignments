import java.util.Arrays;
import java.util.Scanner;

public class ReverseAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want in the array: ");
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("The elements in the array is: " + Arrays.toString(arr));
        for (int i = 0; i < arraySize / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arraySize - 1 - i];
            arr[arraySize - 1 - i] = temp;
        }
        System.out.println("The reversed array is: " + Arrays.toString(arr));
        sc.close();
    }
}
