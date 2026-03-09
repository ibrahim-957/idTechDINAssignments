package week.three;

public class SumOfEachLayerInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int cols = matrix[0].length;
        for (int col = 0; col < cols; col++) {
            int sum = 0;
            for (int[] ints : matrix) {
                sum += ints[col];
            }
            System.out.println("Column " + col + " sum = " + sum);
        }
    }
}
