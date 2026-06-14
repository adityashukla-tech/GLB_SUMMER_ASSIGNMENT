package summer_assignments.DAY_28;
import java.util.*;
public class Q112_contact_management_system {
    static class Contact {
        int id;
        String name;
        String phone;
        String email;

        Contact(int id, String name, String phone, String email) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contactList = new ArrayList<>();
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
                    addContact(sc, contactList);
                    break;
                case 2:
                    viewAllContacts(contactList);
                    break;
                case 3:
                    searchContactById(sc, contactList);
                    break;
                case 4:
                    running = false;
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
        System.out.println("                     CONTACT MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Add New Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Search Contact by ID");
        System.out.println("4. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }
    public static void addContact(Scanner sc, ArrayList<Contact> contactList) {
        System.out.println("\n--- ADD NEW CONTACT ---");
        int id = -1;

        while (id <= 0) {
            System.out.print("Enter Unique Contact ID (Positive Integer): ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("Invalid! ID must be greater than 0.");
                } else if (findContact(contactList, id) != null) {
                    System.out.println("Error: A contact with ID " + id + " already exists!");
                    id = -1;
                }
            } else {
                System.out.println("Error: Contact ID must be an integer value.");
                sc.nextLine();
            }
        }
        System.out.print("Enter Contact Full Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine().trim();
        System.out.print("Enter Email Address: ");
        String email = sc.nextLine().trim();

        contactList.add(new Contact(id, name, phone, email));
        System.out.println("Success: Contact record saved to the directory!");
    }
    public static void viewAllContacts(ArrayList<Contact> contactList) {
        System.out.println("\n--- CONTACT DIRECTORY ---");
        if (contactList.isEmpty()) {
            System.out.println("No records found in the contact directory.");
            return;
        }
        System.out.printf("%-10s %-25s %-15s %-25s\n", "ID", "Name", "Phone", "Email");
        System.out.println("-".repeat(75));
        for (Contact c : contactList) {
            System.out.printf("%-10d %-25s %-15s %-25s\n", c.id, c.name, c.phone, c.email);
        }
    }
    public static void searchContactById(Scanner sc, ArrayList<Contact> contactList) {
        System.out.println("\n--- SEARCH CONTACT RECORD ---");
        if (contactList.isEmpty()) {
            System.out.println("Contact directory is currently empty.");
            return;
        }
        System.out.print("Enter Contact ID to search: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format entered.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Contact target = findContact(contactList, id);
        if (target != null) {
            System.out.println("\nRecord Found:");
            System.out.println("-".repeat(45));
            System.out.println("ID            : " + target.id);
            System.out.println("Full Name     : " + target.name);
            System.out.println("Phone Number  : " + target.phone);
            System.out.println("Email Address : " + target.email);
            System.out.println("-".repeat(45));
        } else {
            System.out.println("Record Not Found: No contact found matching ID " + id);
        }
    }
    public static Contact findContact(ArrayList<Contact> contactList, int id) {
        for (Contact c : contactList) {
            if (c.id == id) {
                return c;
            }
        }
        return null;
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          CONTACT DIRECTORY OFFLINE. APPLICATION TERMINATED.");
        System.out.println("=".repeat(60));
    }
}