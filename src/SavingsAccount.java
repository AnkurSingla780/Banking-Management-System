package src;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(
            String accountNumber,
            String accountHolderName,
            double balance,
            double interestRate) {

        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest() {

        double interest = getBalance() * interestRate / 100;

        deposit(interest);
    }

    @Override
    public String toString() {

        return super.toString()
                + "\nAccount Type : Savings"
                + "\nInterest Rate : "
                + interestRate + "%";
    }
}