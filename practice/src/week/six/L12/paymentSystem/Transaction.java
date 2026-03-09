package week.six.L12.paymentSystem;

public abstract class Transaction implements Payable {
    protected String paymentMethod;

    public Transaction(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String getPaymentMethod() {
        return paymentMethod;
    }

    abstract boolean validateTransaction(double amount);
}
