package summer_assignments.DAY_26;
import java.util.*;
public class Q103_ATM_Simulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 10000.00;
        boolean operating = true;
        while (operating) {
            displayMenu();
            if (!sc.hasNextInt()) {
                System.out.println("\nError: Please enter a valid numerical option.");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    checkBalance(balance);
                    break;
                case 2:
                    balance = deposit(sc, balance);
                    break;
                case 3:
                    balance = withdraw(sc, balance);
                    break;
                case 4:
                    operating = false;
                    break;
                default:
                    System.out.println("\nInvalid Option! Please select a choice from 1 to 4.");
            }
        }
        displayExitBanner();
        sc.close();
    }
    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                     AUTOMATED TELLER MACHINE");
        System.out.println("=".repeat(60));
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit / Terminate Session");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }
    public static void checkBalance(double balance) {
        System.out.println("\n" + "-".repeat(40));
        System.out.printf("Current Account Balance: $%,.2f\n", balance);
        System.out.println("-".repeat(40));
    }
    public static double deposit(Scanner sc, double balance) {
        System.out.print("\nEnter Amount to Deposit: ₹");
        if (!sc.hasNextDouble()) {
            System.out.println("Transaction Failed: Invalid numeric amount entry.");
            sc.nextLine();
            return balance;
        }
        double amount = sc.nextDouble();
        sc.nextLine();
        if (amount <= 0) {
            System.out.println("Transaction Failed: Deposit amount must be greater than zero.");
        } else {
            balance += amount;
            System.out.printf("Success: $%,.2f successfully deposited!\n", amount);
            System.out.printf("Updated Balance: $%,.2f\n", balance);
        }
        return balance;
    }
    public static double withdraw(Scanner sc, double balance) {
        System.out.print("\nEnter Amount to Withdraw: $");
        if (!sc.hasNextDouble()) {
            System.out.println("Transaction Failed: Invalid numeric amount entry.");
            sc.nextLine();
            return balance;
        }
        double amount = sc.nextDouble();
        sc.nextLine();
        if (amount <= 0) {
            System.out.println("Transaction Failed: Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Transaction Failed: Insufficient funds available inside account.");
        } else {
            balance -= amount;
            System.out.printf("Success: Please collect your cash of $%,.2f\n", amount);
            System.out.printf("Remaining Balance: $%,.2f\n", balance);
        }
        return balance;
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          THANK YOU FOR USING OUR ATM SERVICES! EXITING.");
        System.out.println("=".repeat(60));
    }
}