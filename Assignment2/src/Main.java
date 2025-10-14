public class Main {
    public static void main(String[] args) {
        int age = 25;
        float price = 19.99F;
        char initial = 'A';
        boolean isStudent = true;

        Object[] values = {age, price, initial, isStudent};

        for (Object value : values) {
            System.out.println(value);
        }

        System.out.println("------------------------------------");

        byte b = 100;
        short s = 3200;
        int i = 100000;
        long l = 123456789L;
        float f = 45.75F;
        double d = 100.3456;

        Object[] data = {b, s, i, l, f, d};
        for (Object value : data) {
            System.out.println(value);
        }

        System.out.println("------------------------------------");

        float result1 = s + f;
        double result2 = l * 5;
        double result3 = d + b;

        Object[] data1 = {result1, result2, result3};
        for (Object value : data1) {
            System.out.println(value);
        }

        System.out.println("------------------------------------");

        String name = "Ibrahim Naghiyev";
        System.out.println("Full Name: " + name);

        System.out.println("------------------------------------");

        double priceDouble = 12.99;
        int priceInt = (int)priceDouble;

        System.out.println("Double Price: " + priceDouble);
        System.out.println("Int Price: " + priceInt);

        System.out.println("------------------------------------");

        char letter = 'A';
        System.out.println("Letter: " + letter);
        System.out.println("Ascii Value: " + (int) letter);

        System.out.println("------------------------------------");

        boolean isAdult = true;
        boolean hasDrivingLicense = false;
        System.out.println("He/She is adult that " + isAdult);
        System.out.println("He/She has driving license that " + hasDrivingLicense);
    }
}
