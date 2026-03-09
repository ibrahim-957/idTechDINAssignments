package week.three;

public class FindMaxAndMinInTwoDMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int min = matrix[0][0];
        int max = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt < min) {
                    min = anInt;
                }
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        System.out.println("Min value = " + min);
        System.out.println("Max value = " + max);
    }
}
