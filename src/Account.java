package src;

public class Account {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber,
                   String accountHolderName,
                   double balance) {

        if (balance < 0) {
            throw new IllegalArgumentException(
                "Balance cannot be negative."
            );
        }

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public String toString() {

        return "Account Number : " + accountNumber +
               "\nAccount Holder : " + accountHolderName +
               "\nBalance : ₹" + balance;
    }
}