package src;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(Account account) {
        accounts.add(account);
    }

    public void displayAllAccounts() {

        if(accounts.isEmpty()) {
            System.out.println("No Accounts Found.");
            return;
        }

        for(Account acc : accounts) {
            System.out.println(acc);
            System.out.println("----------------");
        }
    }
}