import java.util.Scanner;

public class AreaOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int resultRectangle = area(n, m);
        double resultSquare = area(n);
        System.out.println(resultRectangle);
        System.out.println(resultSquare);
    }

    static double area(int side) {
        return Math.pow(side, 2);
    }

    static int area(int length, int width) {
        return length * width;
    }
}
