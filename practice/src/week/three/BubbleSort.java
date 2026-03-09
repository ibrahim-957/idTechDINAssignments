package week.three;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 3, 4, 5};
        bubbleSort(arr);
        for(int j : arr){
            System.out.println(j);
        }
    }
    public static void bubbleSort(int[] arr) {
        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
