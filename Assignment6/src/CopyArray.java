import java.util.Arrays;
import java.util.Scanner;

public class CopyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want in the array: ");
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("The elements in the array is: " + Arrays.toString(arr));

        int[] copy = Arrays.copyOf(arr, arraySize);
        System.out.println("The elements in the copy is: " + Arrays.toString(copy));
        sc.close();
        System.arraycopy(arr,)
    }
}
