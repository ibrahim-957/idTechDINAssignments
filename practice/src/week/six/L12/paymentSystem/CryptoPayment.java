package week.six.L12.paymentSystem;

public class CryptoPayment extends Transaction {
    public CryptoPayment() {
        super("Crypto");
    }

    @Override
    public void pay(double amount) {
        if (validateTransaction(amount)) {
            System.out.println("Paid $" + amount + " using Crypto.");
        } else {
            System.out.println("Crypto payment failed validation.");
        }
    }

    @Override
    public boolean validateTransaction(double amount) {
        return amount > 0;
    }
}
