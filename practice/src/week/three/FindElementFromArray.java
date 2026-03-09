package week.three;

public class FindElementFromArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Target found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Target value not found in the array.");
        }
    }
}
