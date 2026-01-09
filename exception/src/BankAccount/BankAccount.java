package BankAccount;

import java.math.BigDecimal;

public class BankAccount {
    BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal amount){
        if (amount.compareTo(balance)>0){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance = balance.subtract(amount);
        System.out.println("Withdraw Successful. Balance is "+balance);
    }
}
