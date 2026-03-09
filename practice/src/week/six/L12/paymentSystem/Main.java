package week.six.L12.paymentSystem;

public class Main {
    public static void main(String[] args) {
        FraudChecker fraudChecker = amount -> amount > 5000;

        Payable payment1 = new CreditCardPayment();
        Payable payment2 = new CryptoPayment();

        double amount = 3000;

        if (fraudChecker.check(amount)) {
            System.out.println("Warning: Possible fraud detected!");
        } else {
            payment1.pay(amount);
            System.out.println("Method: " + payment1.getPaymentMethod());
        }

        System.out.println();

        amount = 7000;

        if (fraudChecker.check(amount)) {
            System.out.println("Warning: Possible fraud detected!");
        } else {
            payment2.pay(amount);
            System.out.println("Method: " + payment2.getPaymentMethod());
        }
    }
}
