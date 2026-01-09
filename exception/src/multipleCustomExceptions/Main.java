package multipleCustomExceptions;

public class Main {
    public static void main(String[] args) {
        withdraw("1234", 400);
    }

    static void withdraw(String pin, double amount){
        if (!pin.equals("1234"))
            throw new InvalidPinException("Invalid Pin");

        if (amount > 1000)
            throw new DailyLimitExceededException("Daily Limit Exceeded");

        if (amount > 500)
            throw new InsufficientBalanceException("Insufficient Balance");

        System.out.println("Withdraw Successful. Amount is "+amount);
    }
}
