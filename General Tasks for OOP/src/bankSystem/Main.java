package bankSystem;

public class Main {
    public static void main(String[] args) {
        BankAccount[] bankAccounts = new BankAccount[2];

        bankAccounts[0] = new SavingAccount(1000);
        bankAccounts[1] = new CheckingAccount(2000);

        for (int i = 0; i < bankAccounts.length; i++) {
            bankAccounts[i].withdraw(500);
            bankAccounts[i].deposit(500);
            System.out.println("Final balance: " + bankAccounts[i].getBalance());
            System.out.println("-----");
        }
    }
}
