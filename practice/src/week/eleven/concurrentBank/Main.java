package week.eleven.concurrentBank;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Account account = new Account("Shared Account", 1000);

        System.out.println("=== Starting Balance: " + account.getBalance() + " ===\n");

        System.out.println("=== Runnable Threads ===");
        ExecutorService executor1 = Executors.newFixedThreadPool(3);
        executor1.submit(new BankTransaction(account));
        executor1.submit(new BankTransaction(account));
        executor1.submit(new BankTransaction(account));
        executor1.shutdown();
        executor1.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("\nBalance after Runnable threads: " + account.getBalance());

        System.out.println("\n=== Volatile Flag Demo ===");
        TransactionWorker worker = new TransactionWorker(account);
        Thread workerThread = new Thread(worker);
        workerThread.start();

        Thread.sleep(10);
        worker.stop();
        workerThread.join();
        System.out.println("Worker stopped. Balance: " + account.getBalance());

        System.out.println("\n=== Callable + Future ===");
        ExecutorService executor2 = Executors.newFixedThreadPool(3);
        Future<Double> future1 = executor2.submit(new BalanceChecker(account));
        Future<Double> future2 = executor2.submit(new BalanceChecker(account));
        Future<Double> future3 = executor2.submit(new BalanceChecker(account));

        System.out.println("Future 1 result: " + future1.get());
        System.out.println("Future 2 result: " + future2.get());
        System.out.println("Future 3 result: " + future3.get());

        executor2.shutdown();
        System.out.println("\nFinal balance: " + account.getBalance());
    }
}
