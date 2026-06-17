package summer_assignments.DAY_30;
import java.util.*;
public class Q118_mini_library_system {
    static class Book {
        int id;
        String title;
        boolean isAvailable;

        Book(int id, String title) {
            this.id = id;
            this.title = title;
            this.isAvailable = true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
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
                    addBook(sc, books);
                    break;
                case 2:
                    viewBooks(books);
                    break;
                case 3:
                    borrowBook(sc, books);
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
        System.out.println("                     MINI LIBRARY SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Borrow Book");
        System.out.println("4. Exit");
        System.out.println("=".repeat(60));
        System.out.print("Select an Operation: ");
    }

    public static void addBook(Scanner sc, ArrayList<Book> books) {
        System.out.println("\n--- ADD BOOK ---");
        int id = -1;

        while (id <= 0) {
            System.out.print("Enter Book ID: ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("Invalid ID! Must be greater than 0.");
                } else if (findBook(books, id) != null) {
                    System.out.println("Error: Book ID already exists!");
                    id = -1;
                }
            } else {
                System.out.println("Error: Numeric input required.");
                sc.nextLine();
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine().trim();

        books.add(new Book(id, title));
        System.out.println("Success: Book added to inventory.");
    }

    public static void viewBooks(ArrayList<Book> books) {
        System.out.println("\n--- INVENTORY ---");
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.printf("%-10s %-35s %-15s\n", "ID", "Title", "Status");
        System.out.println("-".repeat(60));
        for (Book b : books) {
            String status = b.isAvailable ? "Available" : "Borrowed";
            System.out.printf("%-10d %-35s %-15s\n", b.id, b.title, status);
        }
    }

    public static void borrowBook(Scanner sc, ArrayList<Book> books) {
        System.out.println("\n--- BORROW BOOK ---");
        if (books.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.print("Enter Book ID to borrow: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Book b = findBook(books, id);
        if (b == null) {
            System.out.println("Error: Book not found.");
        } else if (!b.isAvailable) {
            System.out.println("Error: Book is already borrowed.");
        } else {
            b.isAvailable = false;
            System.out.println("Success: You have borrowed the book.");
        }
    }

    public static Book findBook(ArrayList<Book> books, int id) {
        for (Book b : books) {
            if (b.id == id) {
                return b;
            }
        }
        return null;
    }

    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          SYSTEM CLOSED SECURELY.");
        System.out.println("=".repeat(60));
    }
}