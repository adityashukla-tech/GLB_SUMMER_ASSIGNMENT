package summer_assignments.DAY_26;
import java.util.*;
public class Q102_voting_eligibility_system {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        display();
        boolean running = true;
        while (running) {
            VoterRegistration(sc);
            System.out.print("\nWould you like to check eligibility for another person?\nEnter YES to Continue, NO to EXIT: ");
            String ans = sc.nextLine().trim().toLowerCase();
            if (!ans.equals("yes")) {
                running = false;
            }
        }
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                SYSTEM CLOSED. THANK YOU!");
        System.out.println("=".repeat(60));
        sc.close();
    }
    public static void display() {
        System.out.println("=".repeat(60));
        System.out.println("                  VOTING ELIGIBILITY SYSTEM");
        System.out.println("=".repeat(60));
    }

    public static void VoterRegistration(Scanner sc) {
        System.out.print("\nEnter the Voter's Name: ");
        String name = sc.nextLine().trim();

        int age = -1;
        while (age <0 || age >125) {
            System.out.print("Enter Age: ");
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                sc.nextLine();
                if (age < 0 || age > 125) {
                    System.out.println("Invalid Entry! Please enter a realistic age (0 to 125).");
                }
            } else {
                System.out.println("Error: Age must be entered as a whole number.");
                sc.nextLine();
            }
        }Report(name, age);
    }
    public static void Report(String name, int age) {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("VOTER PROFILE SYSTEM REPORT");
        System.out.println("-".repeat(40));
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        if (age >= 18) {
            System.out.println("Status: ELIGIBLE TO VOTE ");
        } else {
            int yearsLeft = 18 - age;
            System.out.println("Status: NOT ELIGIBLE TO VOTE ");
            System.out.println("Notice: " + name + " will be eligible to register in " + yearsLeft + " year(s).");
        }
        System.out.println("-".repeat(40));
    }
}