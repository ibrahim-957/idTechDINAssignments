package week.six.L12.paymentSystem;

public interface Payable {
    void pay(double amount);

    String getPaymentMethod();
}
