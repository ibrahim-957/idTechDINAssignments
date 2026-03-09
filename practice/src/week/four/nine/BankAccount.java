package week.four.nine;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    static int countOfCreatedAccounts = 0;

    public BankAccount() {
        countOfCreatedAccounts++;
    }
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        countOfCreatedAccounts++;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static int getCountOfCreatedAccounts() {
        return countOfCreatedAccounts;
    }

    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
        } else {
            System.out.println("Insufficient amount");
        }
    }
    public void withdraw(double amount){
        if (balance >= amount){
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("1","Ibrahim",1000);
        BankAccount bankAccount2 = new BankAccount("2","Shahin",1000);
        bankAccount1.withdraw(500);
        bankAccount2.deposit(500);
        System.out.println(bankAccount1);
        System.out.println(bankAccount2);
    }
}
