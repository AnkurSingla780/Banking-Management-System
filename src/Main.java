package src;
import java.util.Scanner;      
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        boolean running = true;
        do{
                System.out.println("----------------------");
                System.out.println("Bank Management System");
                System.out.println("----------------------");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Display All Accounts");
                System.out.println("5. Search Account");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline
        
                
        
                switch (choice) {
                        case 1:
                        System.out.print("Enter Account Number: ");
                        String accountNumber = sc.nextLine();
                        if(bank.findAccount(accountNumber) != null) {
                                        System.out.println("Account with this number already exists.");
                                        break;
                                }
                        System.out.print("Enter Account Holder Name: ");
                        String accountHolderName = sc.nextLine();
                        System.out.print("Enter Initial Balance: ");
                        double balance = sc.nextDouble();
                        sc.nextLine(); // Consume newline
                        if (balance < 0) {
                                        System.out.println("Initial balance cannot be negative.");
                                        break;
                                }
                        try {
                                Account newAccount = new Account(accountNumber, accountHolderName, balance);
                                bank.createAccount(newAccount);
                                System.out.println("Account created successfully.");
                        } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                        }
                        break;
                        case 2:
                        System.out.print("Enter Account Number: ");
                        String depositAccountNumber = sc.nextLine();
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = sc.nextDouble();
                        if (bank.deposit(depositAccountNumber, depositAmount)) {
                                System.out.println("Deposit successful.");
                        } else {
                                System.out.println("Deposit failed. Check account number or amount.");
                        }
                        break;
                        case 3:
                        System.out.print("Enter Account Number: ");
                        String withdrawAccountNumber = sc.nextLine();
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        if (bank.withdraw(withdrawAccountNumber, withdrawAmount)) {
                                System.out.println("Withdrawal successful.");
                        } else {
                                System.out.println("Withdrawal failed. Check account number or amount.");
                        }
                        break;
                        case 4:
                        bank.displayAllAccounts();
                        break;
                        case 5:
                        System.out.print("Enter Account Number to Search: ");
                        String searchAccountNumber = sc.nextLine();
                        Account foundAccount = bank.findAccount(searchAccountNumber);
                        if (foundAccount != null) {
                                System.out.println("Account Found:");
                                System.out.println(foundAccount);
                        } else {
                                System.out.println("Account not found.");
                        }
                        break;
                        case 6:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                        default:
                        System.out.println("Invalid choice. Please try again.");
                }
        }
        while(running);
           }
}