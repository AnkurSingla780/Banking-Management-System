package src;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(
            String accountNumber,
            String accountHolderName,
            double balance,
            double overdraftLimit) {

        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (getBalance() + overdraftLimit >= amount) {

            setBalance(getBalance() - amount);

            getTransactions().add(
                    new Transaction(
                            "Withdraw",
                            amount
                    )
            );

            return true;
        }

        return false;
    }

    @Override
    public String toString() {

        return super.toString()
                + "\nAccount Type : Current"
                + "\nOverdraft Limit : ₹"
                + overdraftLimit;
    }
}