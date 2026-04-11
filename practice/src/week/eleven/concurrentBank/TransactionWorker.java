package week.eleven.concurrentBank;

public class TransactionWorker implements Runnable {
    private Account account;
    private volatile boolean running = true;

    public TransactionWorker(Account account) {
        this.account = account;
    }

    public void stop(){
        running = false;
    }


    @Override
    public void run() {
        int count = 0;
        while (running && count < 5) {
            account.deposit(10);
            account.withdraw(5);
            count++;
        }
    }
}
