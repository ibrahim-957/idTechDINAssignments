package week.six.L12.paymentSystem;

public class CreditCardPayment extends Transaction {
    public CreditCardPayment() {
        super("Credit Card");
    }

    @Override
    boolean validateTransaction(double amount) {
        return amount > 0 && amount <= 10000;
    }

    @Override
    public void pay(double amount) {
        if (validateTransaction(amount)) {
            System.out.println("Paid $" + amount + " using Credit Card.");
        } else {
            System.out.println("Credit Card payment failed validation.");
        }
    }
}
