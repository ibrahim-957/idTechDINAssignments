package week.three;

public class DiagonalSumInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int rows = matrix.length;
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            sum += matrix[row][row];
        }
        System.out.println(sum);
    }
}
