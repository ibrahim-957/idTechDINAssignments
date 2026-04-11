package week.eleven.concurrentBank;

public class Account {
    private double balance;
    private String owner;

    public Account(String owner, double balance) {
        this.balance = balance;
        this.owner = owner;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(Thread.currentThread().getName()
                    + " deposited " + amount
                    + " | Balance: " + balance);
        }
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " withdrawn " + amount
                    + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " insufficient funds");
        }
    }
}
