package multipleCatchBlocks;

public class Main {
    public static void main(String[] args) {
        try {
            String text = null;
            System.out.println(text.length());

            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
        } catch (NullPointerException e) {
            System.out.println("Error: Null value accessed.");
        }
    }
}
