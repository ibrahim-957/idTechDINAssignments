package arrayIndexError;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            System.out.print("Enter array length: ");
            int length = input.nextInt();
            int[] array = new int[length];
            for(int i = 0; i < array.length; i++){
                System.out.print("Enter array element: ");
                array[i] = input.nextInt();
            }
            System.out.print("Choose index you want: ");
            int choice = input.nextInt();
            int element = array[choice];
            System.out.println("Element you choose: " + element);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        finally{
            input.close();
        }
    }
}
