package summer_assignments.DAY_29;
import java.util.*;
public class Q114_menu_driven_array_operation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int size = 0;
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
                    size = initializeArray(sc, arr);
                    break;
                case 2:
                    displayArray(arr, size);
                    break;
                case 3:
                    if (size >= arr.length) {
                        System.out.println("\nError: Array capacity maxed out. Cannot insert.");
                    } else {
                        size = insertElement(sc, arr, size);
                    }
                    break;
                case 4:
                    size = deleteElement(sc, arr, size);
                    break;
                case 5:
                    searchElement(sc, arr, size);
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
        System.out.println("                     MENU DRIVEN ARRAY OPERATIONS");
        System.out.println("=".repeat(60));
        System.out.println("1. Initialize Array Elements");
        System.out.println("2. Display Array Elements");
        System.out.println("3. Insert Element at Index");
        System.out.println("4. Delete Element from Index");
        System.out.println("5. Search Element");
        System.out.println("6. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }

    public static int initializeArray(Scanner sc, int[] arr) {
        System.out.println("\n--- INITIALIZE ARRAY ---");
        int n = -1;
        while (n <= 0 || n > arr.length) {
            System.out.print("Enter number of elements to populate (1 to " + arr.length + "): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();
                if (n <= 0 || n > arr.length) {
                    System.out.println("Invalid size constraint window!");
                }
            } else {
                System.out.println("Error: Size must be entered as a valid integer configuration.");
                sc.nextLine();
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = getValidInteger(sc, "Enter element at index " + i + ": ");
        }
        System.out.println("Success: Array tracking initialized safely.");
        return n;
    }

    public static void displayArray(int[] arr, int size) {
        System.out.println("\n--- DISPLAY ARRAY ---");
        if (size == 0) {
            System.out.println("Array sequence contains zero variables.");
            return;
        }
        System.out.print("Current Elements: [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + (i == size - 1 ? "" : ", "));
        }
        System.out.println(" ]");
        System.out.println("Total Allocated Elements: " + size);
    }

    public static int insertElement(Scanner sc, int[] arr, int size) {
        System.out.println("\n--- INSERT ELEMENT ---");
        int index = -1;
        while (index < 0 || index > size) {
            System.out.print("Enter Target Position Index (0 to " + size + "): ");
            if (sc.hasNextInt()) {
                index = sc.nextInt();
                sc.nextLine();
                if (index < 0 || index > size) {
                    System.out.println("Index is located completely out of sequence bounds!");
                }
            } else {
                System.out.println("Error: Index choice must be a non-negative whole integer value.");
                sc.nextLine();
            }
        }

        int value = getValidInteger(sc, "Enter element value to insert: ");

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        System.out.println("Success: Target data value placed into array index chain.");
        return size + 1;
    }

    public static int deleteElement(Scanner sc, int[] arr, int size) {
        System.out.println("\n--- DELETE ELEMENT ---");
        if (size == 0) {
            System.out.println("Underflow Alert: System data allocation holds zero index values.");
            return size;
        }

        int index = -1;
        while (index < 0 || index >= size) {
            System.out.print("Enter target Index to remove (0 to " + (size - 1) + "): ");
            if (sc.hasNextInt()) {
                index = sc.nextInt();
                sc.nextLine();
                if (index < 0 || index >= size) {
                    System.out.println("Target deletion index mapping location does not exist!");
                }
            } else {
                System.out.println("Error: Index selection parameter must be a valid complete whole number.");
                sc.nextLine();
            }
        }

        int removedValue = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        System.out.println("Success: Value " + removedValue + " wiped from array chain coordinate index " + index);
        return size - 1;
    }

    public static void searchElement(Scanner sc, int[] arr, int size) {
        System.out.println("\n--- SEARCH ELEMENT ---");
        if (size == 0) {
            System.out.println("Active array tracking vector size is zero.");
            return;
        }

        int target = getValidInteger(sc, "Enter value to search for: ");
        int foundIndex = -1;

        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Record Found: Matching value found sitting at index location sequence -> " + foundIndex);
        } else {
            System.out.println("Record Not Found: No matching target data signatures map inside the array.");
        }
    }

    public static int getValidInteger(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } else {
                System.out.println("Error: Numerical parameter exception. Input must be an integer.");
                sc.nextLine();
            }
        }
    }

    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          ARRAY MATRIX ENGINE OFFLINE. CORE RUNTIME TERMINATED.");
        System.out.println("=".repeat(60));
    }
}