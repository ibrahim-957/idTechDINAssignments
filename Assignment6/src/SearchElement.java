import java.util.Arrays;
import java.util.Scanner;

public class SearchElement {
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

        sc.nextLine();
        System.out.print("Enter the element you want to check: ");
        int element = sc.nextInt();
        for(int value : arr){
            if(value == element){
                System.out.println("The element is present in the array");
                break;
            }
            else{
                System.out.println("The element is not present in the array");
                break;
            }
        }
        sc.close();

    }
}
