package summer_assignments.DAY_29;
import java.util.*;
public class Q113_Menu_driven_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

            if (choice == 8) {
                running = false;
                continue;
            }

            if (choice < 1 || choice > 8) {
                System.out.println("\nInvalid Option! Please select a choice from 1 to 8.");
                continue;
            }

            executeCalculation(choice, sc);
        }
        displayExitBanner();
        sc.close();
    }

    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                     MENU DRIVEN CALCULATOR");
        System.out.println("=".repeat(60));
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulus (%)");
        System.out.println("6. Exponentiation (^)");
        System.out.println("7. Square Root (√)");
        System.out.println("8. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }

    public static void executeCalculation(int choice, Scanner sc) {
        System.out.println("\n--- ENTER OPERANDS ---");

        if (choice == 7) {
            double num = getValidDouble(sc, "Enter Number: ");
            System.out.println("\nResult:");
            System.out.println("-".repeat(40));
            if (num < 0) {
                System.out.println("Math Error: Cannot calculate square root of a negative number.");
            } else {
                System.out.printf("Square Root of %.2f = %.2f\n", num, Math.sqrt(num));
            }
            System.out.println("-".repeat(40));
            return;
        }

        double num1 = getValidDouble(sc, "Enter First Number: ");
        double num2 = getValidDouble(sc, "Enter Second Number: ");

        System.out.println("\nResult:");
        System.out.println("-".repeat(40));

        switch (choice) {
            case 1:
                System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, (num1 + num2));
                break;
            case 2:
                System.out.printf("%.2f - %.2f = %.2f\n", num1, num2, (num1 - num2));
                break;
            case 3:
                System.out.printf("%.2f * %.2f = %.2f\n", num1, num2, (num1 * num2));
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Math Error: Division by zero is undefined.");
                } else {
                    System.out.printf("%.2f / %.2f = %.2f\n", num1, num2, (num1 / num2));
                }
                break;
            case 5:
                if (num2 == 0) {
                    System.out.println("Math Error: Modulus by zero is undefined.");
                } else {
                    System.out.printf("%.2f %% %.2f = %.2f\n", num1, num2, (num1 % num2));
                }
                break;
            case 6:
                System.out.printf("%.2f ^ %.2f = %.2f\n", num1, num2, Math.pow(num1, num2));
                break;
        }
        System.out.println("-".repeat(40));
    }

    public static double getValidDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            } else {
                System.out.println("Error: Input must be a valid numerical value.");
                sc.nextLine();
            }
        }
    }

    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          CALCULATOR ENGINE TERMINATED. HAVE A GREAT DAY!");
        System.out.println("=".repeat(60));
    }
}