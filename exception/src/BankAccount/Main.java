package BankAccount;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(BigDecimal.valueOf(2000));
        account.withdraw(BigDecimal.valueOf(2500));
    }
}
