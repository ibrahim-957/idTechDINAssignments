package week.eleven.concurrentBank;

import java.util.concurrent.Callable;

public class BalanceChecker implements Callable<Double> {
    private Account account;

    public BalanceChecker(Account account) {
        this.account = account;
    }


    @Override
    public Double call() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
        }
        for (int i = 0; i < 5; i++) {
            account.withdraw(50);
        }
        return account.getBalance();
    }
}
