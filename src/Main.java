package src;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Account acc1 =
                new Account(
                        "ACC101",
                        "Ankur",
                        5000
                );

        Account acc2 =
                new Account(
                        "ACC102",
                        "Rahul",
                        8000
                );

        bank.createAccount(acc1);
        bank.createAccount(acc2);

        bank.displayAllAccounts();
    }
}