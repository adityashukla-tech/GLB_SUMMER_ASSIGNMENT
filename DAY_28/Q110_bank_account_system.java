package summer_assignments.DAY_28;
import java.util.*;
public class Q110_bank_account_system {
    static class BankAccount {
        String accountNumber;
        String accountHolder;
        double balance;

        BankAccount(String accountNumber, String accountHolder, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accountsList = new ArrayList<>();
        boolean running = true;
        while (running) {
            displayMenu();
            if (!sc.hasNextInt()) {
                System.out.println("\nError: Please enter a valid numerical choice.");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAccount(sc, accountsList);
                    break;
                case 2:
                    depositMoney(sc, accountsList);
                    break;
                case 3:
                    withdrawMoney(sc, accountsList);
                    break;
                case 4:
                    checkBalance(sc, accountsList);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid Option! Please select a choice from 1 to 5.");
            }
        }
        displayExitBanner();
        sc.close();
    }
    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                     BANKING MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Create New Bank Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Check Account Balance");
        System.out.println("5. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }
    public static void createAccount(Scanner sc, ArrayList<BankAccount> accountsList) {
        System.out.println("\n--- CREATE NEW ACCOUNT ---");
        String accountNumber = "";

        while (accountNumber.isEmpty()) {
            System.out.print("Enter Unique Account Number: ");
            accountNumber = sc.nextLine().trim();

            if (accountNumber.isEmpty()) {
                System.out.println("Error: Account number cannot be blank.");
            } else if (findAccount(accountsList, accountNumber) != null) {
                System.out.println("Error: An account with this number already exists!");
                accountNumber = "";
            }
        }
        System.out.print("Enter Account Holder Full Name: ");
        String accountHolder = sc.nextLine().trim();
        double initialBalance = -1;
        while (initialBalance < 0) {
            System.out.print("Enter Initial Deposit Amount (₹): ");
            if (sc.hasNextDouble()) {
                initialBalance = sc.nextDouble();
                sc.nextLine();
                if (initialBalance < 0) {
                    System.out.println("Invalid! Initial deposit cannot be negative.");
                }
            } else {
                System.out.println("Error: Balance must be entered as a valid decimal value.");
                sc.nextLine();
            }
        }
        accountsList.add(new BankAccount(accountNumber, accountHolder, initialBalance));
        System.out.println("Success: Bank account registered successfully!");
    }
    public static void depositMoney(Scanner sc, ArrayList<BankAccount> accountsList) {
        System.out.println("\n--- DEPOSIT FUNDS ---");
        if (accountsList.isEmpty()) {
            System.out.println("The banking database is currently empty.");
            return;
        }
        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine().trim();

        BankAccount account = findAccount(accountsList, accountNumber);
        if (account == null) {
            System.out.println("Error: No record found matching Account Number " + accountNumber);
            return;
        }
        double amount = -1;
        while (amount <= 0) {
            System.out.print("Enter Amount to Deposit (₹): ");
            if (sc.hasNextDouble()) {
                amount = sc.nextDouble();
                sc.nextLine();
                if (amount <= 0) {
                    System.out.println("Invalid! Deposit amount must be greater than zero.");
                }
            } else {
                System.out.println("Error: Amount must be a valid numerical value.");
                sc.nextLine();
            }
        }
        account.balance += amount;
        System.out.printf("Success: Deposited ₹%,.2f. Updated Balance: ₹%,.2f\n", amount, account.balance);
    }
    public static void withdrawMoney(Scanner sc, ArrayList<BankAccount> accountsList) {
        System.out.println("\n--- WITHDRAW FUNDS ---");
        if (accountsList.isEmpty()) {
            System.out.println("The banking database is currently empty.");
            return;
        }

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine().trim();

        BankAccount account = findAccount(accountsList, accountNumber);
        if (account == null) {
            System.out.println("Error: No record found matching Account Number " + accountNumber);
            return;
        }
        double amount = -1;
        while (amount <= 0) {
            System.out.print("Enter Amount to Withdraw (₹): ");
            if (sc.hasNextDouble()) {
                amount = sc.nextDouble();
                sc.nextLine();
                if (amount <= 0) {
                    System.out.println("Invalid! Withdrawal amount must be greater than zero.");
                }
            } else {
                System.out.println("Error: Amount must be a valid numerical value.");
                sc.nextLine();
            }
        }
        if (amount > account.balance) {
            System.out.printf("Transaction Rejected: Insufficient funds. Available balance: ₹%,.2f\n", account.balance);
        } else {
            account.balance -= amount;
            System.out.printf("Success: Withdrew ₹%,.2f. Remaining Balance: ₹%,.2f\n", amount, account.balance);
        }
    }
    public static void checkBalance(Scanner sc, ArrayList<BankAccount> accountsList) {
        System.out.println("\n--- CHECK BALANCE ---");
        if (accountsList.isEmpty()) {
            System.out.println("The banking database is currently empty.");
            return;
        }
        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine().trim();

        BankAccount account = findAccount(accountsList, accountNumber);
        if (account == null) {
            System.out.println("Error: No record found matching Account Number " + accountNumber);
            return;
        }
        System.out.println("\nAccount Summary:");
        System.out.println("-".repeat(45));
        System.out.println("Account Number : " + account.accountNumber);
        System.out.println("Account Holder : " + account.accountHolder);
        System.out.printf("Current Balance: ₹%,.2f\n", account.balance);
        System.out.println("-".repeat(45));
    }
    public static BankAccount findAccount(ArrayList<BankAccount> accountsList, String accountNumber) {
        for (BankAccount account : accountsList) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          BANK TERMINAL OFFLINE. SESSIONS SECURELY CLOSED.");
        System.out.println("=".repeat(60));
    }
}