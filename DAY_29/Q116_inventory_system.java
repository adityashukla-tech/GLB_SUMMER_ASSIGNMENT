package summer_assignments.DAY_29;
import java.util.*;
public class Q116_inventory_system {
    static class Product {
        int id;
        String name;
        int quantity;
        double price;

        Product(int id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> inventory = new ArrayList<>();
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
                    addProduct(sc, inventory);
                    break;
                case 2:
                    viewInventory(inventory);
                    break;
                case 3:
                    updateStock(sc, inventory);
                    break;
                case 4:
                    searchProduct(sc, inventory);
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
        System.out.println("                     INVENTORY MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Add New Product");
        System.out.println("2. View Inventory Stock");
        System.out.println("3. Update Stock Quantity");
        System.out.println("4. Search Product by ID");
        System.out.println("5. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }

    public static void addProduct(Scanner sc, ArrayList<Product> inventory) {
        System.out.println("\n--- ADD NEW PRODUCT ---");
        int id = -1;

        while (id <= 0) {
            System.out.print("Enter Unique Product ID (Positive Integer): ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("Invalid! ID must be greater than 0.");
                } else if (findProduct(inventory, id) != null) {
                    System.out.println("Error: A product with ID " + id + " already exists!");
                    id = -1;
                }
            } else {
                System.out.println("Error: Product ID must be an integer value.");
                sc.nextLine();
            }
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine().trim();

        int quantity = -1;
        while (quantity < 0) {
            System.out.print("Enter Initial Stock Quantity: ");
            if (sc.hasNextInt()) {
                quantity = sc.nextInt();
                sc.nextLine();
                if (quantity < 0) {
                    System.out.println("Invalid! Quantity cannot be negative.");
                }
            } else {
                System.out.println("Error: Quantity must be a whole number.");
                sc.nextLine();
            }
        }

        double price = -1;
        while (price < 0) {
            System.out.print("Enter Unit Price (₹): ");
            if (sc.hasNextDouble()) {
                price = sc.nextDouble();
                sc.nextLine();
                if (price < 0) {
                    System.out.println("Invalid! Price cannot be negative.");
                }
            } else {
                System.out.println("Error: Price must be a valid decimal value.");
                sc.nextLine();
            }
        }

        inventory.add(new Product(id, name, quantity, price));
        System.out.println("Success: Product registered to repository stock.");
    }

    public static void viewInventory(ArrayList<Product> inventory) {
        System.out.println("\n--- CURRENT INVENTORY STOCK ---");
        if (inventory.isEmpty()) {
            System.out.println("No product stock tracked in the repository directory.");
            return;
        }

        System.out.printf("%-12s %-25s %-15s %-15s\n", "Product ID", "Product Name", "Stock Qty", "Unit Price");
        System.out.println("-".repeat(70));
        for (Product p : inventory) {
            System.out.printf("%-12d %-25s %-15d ₹%,-15.2f\n", p.id, p.name, p.quantity, p.price);
        }
    }

    public static void updateStock(Scanner sc, ArrayList<Product> inventory) {
        System.out.println("\n--- UPDATE STOCK QUANTITY ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory tracking register is currently empty.");
            return;
        }

        System.out.print("Enter Product ID to update: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format format entered.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Product p = findProduct(inventory, id);
        if (p == null) {
            System.out.println("Error: No record matching Product ID " + id + " found.");
            return;
        }

        System.out.println("Current Quantity for " + p.name + ": " + p.quantity);
        int newQuantity = -1;
        while (newQuantity < 0) {
            System.out.print("Enter New Total Stock Quantity: ");
            if (sc.hasNextInt()) {
                newQuantity = sc.nextInt();
                sc.nextLine();
                if (newQuantity < 0) {
                    System.out.println("Invalid! Stock level configuration cannot go below zero.");
                }
            } else {
                System.out.println("Error: Stock volume metrics must be complete integers.");
                sc.nextLine();
            }
        }

        p.quantity = newQuantity;
        System.out.println("Success: Product unit metrics adjusted successfully.");
    }

    public static void searchProduct(Scanner sc, ArrayList<Product> inventory) {
        System.out.println("\n--- SEARCH PRODUCT RECORD ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory tracking register is currently empty.");
            return;
        }

        System.out.print("Enter Product ID to search: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format entered.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Product p = findProduct(inventory, id);
        if (p != null) {
            System.out.println("\nRecord Found:");
            System.out.println("-".repeat(45));
            System.out.println("ID             : " + p.id);
            System.out.println("Product Name   : " + p.name);
            System.out.println("Stock Quantity : " + p.quantity);
            System.out.printf("Unit Price     : ₹%,.2f\n", p.price);
            System.out.println("-".repeat(45));
        } else {
            System.out.println("Record Not Found: No matching signatures mapping to Product ID " + id);
        }
    }

    public static Product findProduct(ArrayList<Product> inventory, int id) {
        for (Product p : inventory) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          INVENTORY TERMINAL OFFLINE. WORKSPACE STORAGE PROTECTED.");
        System.out.println("=".repeat(60));
    }
}