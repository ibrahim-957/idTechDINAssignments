package week.six.L12.paymentSystem;

@FunctionalInterface
public interface FraudChecker {
    boolean check(double amount);
}
