package src;

import java.io.*;
import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;
    private static final String FILE_NAME = "data/accounts.txt";

    public Bank() {
        accounts = new ArrayList<>();
        loadAccountsFromFile();
    }

    public boolean createAccount(Account account) {

        if (findAccount(account.getAccountNumber()) != null) {
            return false;
        }

        accounts.add(account);
        return saveAccountsToFile();
    }

    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Found.");
            return;
        }

        for (Account acc : accounts) {
            System.out.println(acc);
            System.out.println("----------------");
        }
    }

    public Account findAccount(String accountNumber) {

        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }

        return null;
    }

    public boolean deposit(String accountNumber, double amount) {

        Account acc = findAccount(accountNumber);

        if (acc != null && acc.deposit(amount)) {
            return saveAccountsToFile();
        }

        return false;
    }

    public boolean withdraw(String accountNumber, double amount) {

        Account acc = findAccount(accountNumber);

        if (acc != null && acc.withdraw(amount)) {
            return saveAccountsToFile();
        }

        return false;
    }

    private boolean saveAccountsToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Account acc : accounts) {

                writer.write(
                        acc.getAccountNumber() + "," +
                        acc.getAccountHolderName() + "," +
                        acc.getBalance()
                );

                writer.newLine();
            }

            return true;

        } catch (IOException e) {

            System.out.println("Error saving accounts: " + e.getMessage());
            return false;
        }
    }

    private void loadAccountsFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length != 3) {
                    continue;
                }

                Account acc = new Account(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2])
                );

                accounts.add(acc);
            }

        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}