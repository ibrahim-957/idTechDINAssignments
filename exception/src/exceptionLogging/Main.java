package exceptionLogging;

public class Main {
    public static void main(String[] args) {
        try {
            int result = 10/0;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Message: "  + e.getMessage());
            System.out.println("Cause: " + e.getCause());
            System.out.println("Stack Trace: ");
            e.printStackTrace();
        }
    }
}
