public class Main {
    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        System.out.println("Addition (a + b): " + (a + b));
        System.out.println("Subtraction (a - b): " + (a - b));
        System.out.println("Multiplication (a * b): " + (a * b));
        System.out.println("Division (a / b): " + (a / b));
        // ümumilik də data tipi olarak tam ədədləri saxlayan tiplər  bölmə əməliyyatından alınan nəticənin tam hissəsini geri qaytarır yəni 15/4 nəticə olarak 3.75 alınır bununda tam hissəsi 3 olduğu üçün nəticə 3 götürülür.
        System.out.println("Modulus (a % b): " + (a % b));

        System.out.println("----------------------------------");

        float x = 7.5F;
        float y = 2.0F;
        System.out.println("Division (x / y): " + (x / y));

        System.out.println("----------------------------------");

        int k = 10;
        int l = 5;
        int m = 10;
        System.out.println("k > l " + (k > l));
        System.out.println("k < l " + (k < l));
        System.out.println("k == m " + (k == m));
        System.out.println("k != l " + (k != l));
        System.out.println("l >= k "  + (l >= k));

    }
}