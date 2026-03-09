package week.three;

public class FindDuplicateElementFromArray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 1, 5, 4};
        boolean foundDuplicate = false;

        for (int i = 0; i < arr.length; i++) {

            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {
                if (arr[k] == arr[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate element: " + arr[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No duplicate elements found.");
        }
    }
}
