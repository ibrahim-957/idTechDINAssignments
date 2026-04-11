package week.eleven.concurrentBank;

public class BankTransaction implements Runnable {
    private Account account;

    public BankTransaction(Account account) {
        this.account = account;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
        }
        for (int i = 0; i < 5; i++) {
            account.withdraw(50);
        }
    }
}
