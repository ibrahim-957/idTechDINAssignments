import java.util.Scanner;

public class CountEvenAndOddNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you want in the array: ");
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
        int countOdd = 0;
        int countEven = 0;
        for(int i = 0; i < arraySize; i++){
            if(arr[i] % 2 == 0){
                countEven++;
            }
            else{
                countOdd++;
            }
        }
        System.out.println("The count of even numbers is: " + countEven);
        System.out.println("The count of odd numbers is: " + countOdd);
        sc.close();
    }
}
