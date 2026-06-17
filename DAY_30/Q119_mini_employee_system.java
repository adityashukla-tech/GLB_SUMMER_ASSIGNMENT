package summer_assignments.DAY_30;
import java.util.*;
public class Q119_mini_employee_system {
    static class Employee {
        int id;
        String name;
        String department;

        Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
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
                    addEmployee(sc, employees);
                    break;
                case 2:
                    viewEmployees(employees);
                    break;
                case 3:
                    searchEmployee(sc, employees);
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
        System.out.println("                     MINI EMPLOYEE SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Exit");
        System.out.println("=".repeat(60));
        System.out.print("Select an Operation: ");
    }

    public static void addEmployee(Scanner sc, ArrayList<Employee> employees) {
        System.out.println("\n--- ADD EMPLOYEE ---");
        int id = -1;

        while (id <= 0) {
            System.out.print("Enter Employee ID: ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("Invalid ID! Must be greater than 0.");
                } else if (findEmployee(employees, id) != null) {
                    System.out.println("Error: Employee ID already exists!");
                    id = -1;
                }
            } else {
                System.out.println("Error: Numeric input required.");
                sc.nextLine();
            }
        }

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Department: ");
        String department = sc.nextLine().trim();

        employees.add(new Employee(id, name, department));
        System.out.println("Success: Employee record registered.");
    }

    public static void viewEmployees(ArrayList<Employee> employees) {
        System.out.println("\n--- EMPLOYEE DIRECTORY ---");
        if (employees.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        System.out.printf("%-10s %-30s %-20s\n", "ID", "Name", "Department");
        System.out.println("-".repeat(60));
        for (Employee e : employees) {
            System.out.printf("%-10d %-30s %-20s\n", e.id, e.name, e.department);
        }
    }

    public static void searchEmployee(Scanner sc, ArrayList<Employee> employees) {
        System.out.println("\n--- SEARCH EMPLOYEE ---");
        if (employees.isEmpty()) {
            System.out.println("Directory is empty.");
            return;
        }

        System.out.print("Enter Employee ID to search: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Employee e = findEmployee(employees, id);
        if (e == null) {
            System.out.println("Error: Employee not found.");
        } else {
            System.out.println("\nRecord Found:");
            System.out.println("-".repeat(40));
            System.out.println("ID         : " + e.id);
            System.out.println("Name       : " + e.name);
            System.out.println("Department : " + e.department);
            System.out.println("-".repeat(40));
        }
    }

    public static Employee findEmployee(ArrayList<Employee> employees, int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                return e;
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