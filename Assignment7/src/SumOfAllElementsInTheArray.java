import java.util.Scanner;

public class SumOfAllElementsInTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int a = sc.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < a; i++) {
            System.out.print("Enter the elements of the array: ");
            arr[i] = sc.nextInt();
        }
        int result = sumArray(arr);
        System.out.println("The sum of the elements in the array is: " + result);
    }

    static int sumArray(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
}
