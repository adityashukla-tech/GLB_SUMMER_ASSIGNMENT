package summer_assignments.DAY_28;
import java.util.*;
public class Q109_library_management_system {
    static class Book {
        int id;
        String title;
        String author;
        boolean isIssued;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> libraryCatalog = new ArrayList<>();
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
                    addBook(sc, libraryCatalog);
                    break;
                case 2:
                    viewAllBooks(libraryCatalog);
                    break;
                case 3:
                    issueBook(sc, libraryCatalog);
                    break;
                case 4:
                    returnBook(sc, libraryCatalog);
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
        System.out.println("                   LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Add New Book Record");
        System.out.println("2. View Catalog Directory");
        System.out.println("3. Issue Book to Member");
        System.out.println("4. Return Borrowed Book");
        System.out.println("5. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }
    public static void addBook(Scanner sc, ArrayList<Book> libraryCatalog) {
        System.out.println("\n--- ADD NEW BOOK RECORD ---");
        int id = -1;
        while (id <= 0) {
            System.out.print("Enter Unique Book ID (Positive Integer): ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("Invalid! ID must be greater than 0.");
                } else if (findBook(libraryCatalog, id) != null) {
                    System.out.println("Error: A book with ID " + id + " already exists!");
                    id = -1;
                }
            } else {
                System.out.println("Error: Book ID must be an integer value.");
                sc.nextLine();
            }
        }
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine().trim();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine().trim();

        libraryCatalog.add(new Book(id, title, author));
        System.out.println("Success: Book record registered into the catalog!");
    }
    public static void viewAllBooks(ArrayList<Book> libraryCatalog) {
        System.out.println("\n--- CATALOG DIRECTORY ---");
        if (libraryCatalog.isEmpty()) {
            System.out.println("No records found in the library system.");
            return;
        }
        System.out.printf("%-10s %-30s %-25s %-12s\n", "Book ID", "Title", "Author", "Availability");
        System.out.println("-".repeat(80));
        for (Book b : libraryCatalog) {
            String status = b.isIssued ? "Issued Out" : "Available";
            System.out.printf("%-10d %-30s %-25s %-12s\n", b.id, b.title, b.author, status);
        }
    }
    public static void issueBook(Scanner sc, ArrayList<Book> libraryCatalog) {
        System.out.println("\n--- ISSUE BOOK RECORD ---");
        if (libraryCatalog.isEmpty()) {
            System.out.println("The catalog is empty. No transaction can proceed.");
            return;
        }
        System.out.print("Enter Book ID to issue: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format format entered.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Book target = findBook(libraryCatalog, id);
        if (target == null) {
            System.out.println("Error: No record matching Book ID " + id + " found.");
        } else if (target.isIssued) {
            System.out.println("Transaction Rejected: This book is already checked out.");
        } else {
            target.isIssued = true;
            System.out.println("Success: Book marked as Issued.");
        }
    }
    public static void returnBook(Scanner sc, ArrayList<Book> libraryCatalog) {
        System.out.println("\n--- RETURN BOOK RECORD ---");
        if (libraryCatalog.isEmpty()) {
            System.out.println("The catalog is empty.");
            return;
        }
        System.out.print("Enter Book ID to return: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format format entered.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Book target = findBook(libraryCatalog, id);
        if (target == null) {
            System.out.println("Error: No record matching Book ID " + id + " found.");
        } else if (!target.isIssued) {
            System.out.println("Transaction Rejected: This book is already present in shelves.");
        } else {
            target.isIssued = false;
            System.out.println("Success: Book returned safely to the library ecosystem.");
        }
    }
    public static Book findBook(ArrayList<Book> libraryCatalog, int id) {
        for (Book b : libraryCatalog) {
            if (b.id == id) {
                return b;
            }
        }
        return null;
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          LIBRARY TERMINAL OFFLINE. SESSIONS CONCLUDED.");
        System.out.println("=".repeat(60));
    }
}