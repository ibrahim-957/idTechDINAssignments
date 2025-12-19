package bankSystem;

public class SavingAccount extends BankAccount {
    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("SavingAccount deposited " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("SavingAccount withdrawn " + amount);
        }
        else {
            System.out.println("Insufficient funds");
        }
    }

}
