package week.three;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        for (int i = 0; i < matrix.length; i++) {

            int sum = 0;
            System.out.print("Row " + (i + 1) + ": ");

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
                sum += matrix[i][j];
            }

            System.out.println();
            System.out.println("Sum = " + sum);
        }
    }
}
