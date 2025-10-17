import java.util.Scanner;

public class FindMaxAndMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want in the array: ");
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arraySize; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("The maximum element is: " + max);
        System.out.println("The minimum element is: " + min);
        sc.close();
    }
}
