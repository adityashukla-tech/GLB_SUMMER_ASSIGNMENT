package summer_assignments.DAY_29;
import java.util.*;
public class Q115_menu_driven_string_operation {
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

            switch (choice) {
                case 1:
                    reverseString(sc);
                    break;
                case 2:
                    checkPalindrome(sc);
                    break;
                case 3:
                    toggleCase(sc);
                    break;
                case 4:
                    countVowelsAndConsonants(sc);
                    break;
                case 5:
                    searchSubstring(sc);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid Option! Please select a choice from 1 to 6.");
            }
        }
        displayExitBanner();
        sc.close();
    }

    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                     MENU DRIVEN STRING OPERATIONS");
        System.out.println("=".repeat(60));
        System.out.println("1. Reverse a String");
        System.out.println("2. Check Palindrome");
        System.out.println("3. Convert Case (Upper / Lower)");
        System.out.println("4. Count Vowels and Consonants");
        System.out.println("5. Search for a Substring");
        System.out.println("6. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }

    public static void reverseString(Scanner sc) {
        System.out.println("\n--- REVERSE A STRING ---");
        System.out.print("Enter target string: ");
        String input = sc.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println("\nResult:");
        System.out.println("-".repeat(40));
        System.out.println("Original : " + input);
        System.out.println("Reversed : " + reversed);
        System.out.println("-".repeat(40));
    }

    public static void checkPalindrome(Scanner sc) {
        System.out.println("\n--- CHECK PALINDROME ---");
        System.out.print("Enter target string: ");
        String input = sc.nextLine();

        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanInput).reverse().toString();

        System.out.println("\nResult:");
        System.out.println("-".repeat(40));
        if (cleanInput.equals(reversed)) {
            System.out.println("The string is a valid Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
        System.out.println("-".repeat(40));
    }

    public static void toggleCase(Scanner sc) {
        System.out.println("\n--- CONVERT CASE ---");
        System.out.print("Enter target string: ");
        String input = sc.nextLine();

        System.out.println("\nResult:");
        System.out.println("-".repeat(40));
        System.out.println("Uppercase : " + input.toUpperCase());
        System.out.println("Lowercase : " + input.toLowerCase());
        System.out.println("-".repeat(40));
    }

    public static void countVowelsAndConsonants(Scanner sc) {
        System.out.println("\n--- COUNT VOWELS AND CONSONANTS ---");
        System.out.print("Enter target string: ");
        String input = sc.nextLine();

        int vowels = 0;
        int consonants = 0;
        String normalized = input.toLowerCase();

        for (int i = 0; i < normalized.length(); i++) {
            char ch = normalized.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("\nResult:");
        System.out.println("-".repeat(40));
        System.out.println("Total Vowels     : " + vowels);
        System.out.println("Total Consonants : " + consonants);
        System.out.println("-".repeat(40));
    }

    public static void searchSubstring(Scanner sc) {
        System.out.println("\n--- SEARCH FOR A SUBSTRING ---");
        System.out.print("Enter Main String: ");
        String mainString = sc.nextLine();
        System.out.print("Enter Substring to find: ");
        String subString = sc.nextLine();

        int index = mainString.indexOf(subString);

        System.out.println("\nResult:");
        System.out.println("-".repeat(40));
        if (index != -1) {
            System.out.println("Match Found! Substring occurs at index: " + index);
        } else {
            System.out.println("Match Not Found: Substring does not exist inside the main string.");
        }
        System.out.println("-".repeat(40));
    }

    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          STRING ENGINE OFFLINE. WORKSPACE CONCLUDED.");
        System.out.println("=".repeat(60));
    }
}