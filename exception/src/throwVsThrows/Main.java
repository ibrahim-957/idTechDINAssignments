package throwVsThrows;

public class Main {
    public static void main(String[] args) {
        divide(10,0);
        checkAge(17);
    }

    static void checkAge(int age){
        if(age<18){
            throw new IllegalArgumentException("Age must be 18");
        }
        System.out.println("Age is "+age);
    }

    static void divide(int a,int b) throws ArithmeticException{
        System.out.println(a/b);
    }
}
