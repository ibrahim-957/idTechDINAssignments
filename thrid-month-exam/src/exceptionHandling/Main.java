package exceptionHandling;

public class Main {
    public static void main(String[] args) {
        divide(5,0);
    }

    public static void divide(int a, int b){
        if(b==0){
            throw new ArithmeticException("you can't divide to zero");
        }
        System.out.println("result: " + a/b);
    }
}
