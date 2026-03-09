package week.four;

public class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(1, 2));
        System.out.println(calc.add(1, 2, 3));
        System.out.println(calc.factorial(7));
        System.out.println(isPrime(2354));
    }

     int add(int a, int b){
        return a+b;
    }

    int add(int a, int b, int c){
        return a+b+c;
    }

    int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n * factorial(n-1);
    }

    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
