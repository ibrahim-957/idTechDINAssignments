package week.three;

public class FindMinAndMaxFromArray {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 2, 3, 13, 4, 5};
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
