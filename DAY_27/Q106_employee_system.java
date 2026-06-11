package summer_assignments.DAY_27;
import java.util.*;
public class Q106_employee_system {
    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();
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
                    addEmployee(sc, employeeList);
                    break;
                case 2:
                    viewAllEmployees(employeeList);
                    break;
                case 3:
                    searchEmployeeById(sc, employeeList);
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
        System.out.println("                 EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Add New Employee Record");
        System.out.println("2. View All Employee Records");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }
    public static void addEmployee(Scanner sc, ArrayList<Employee> employeeList) {
        System.out.println("\n--- ADD NEW EMPLOYEE RECORD ---");

        int id = -1;
        while (id <= 0) {
            System.out.print("Enter Unique Employee ID (Positive Integer): ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();

                if (id <= 0) {
                    System.out.println("Invalid! ID must be greater than 0.");
                } else if (findEmployee(employeeList, id) != null) {
                    System.out.println("Error: An employee with ID " + id + " already exists!");
                    id = -1;
                }
            } else {
                System.out.println("Error: Employee ID must be a whole number.");
                sc.nextLine();
            }
        }
        System.out.print("Enter Employee Full Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Department: ");
        String department = sc.nextLine().trim();
        double salary = -1;
        while (salary < 0) {
            System.out.print("Enter Monthly Salary (₹): ");
            if (sc.hasNextDouble()) {
                salary = sc.nextDouble();
                sc.nextLine();
                if (salary < 0) {
                    System.out.println("Invalid! Salary cannot be negative.");
                }
            } else {
                System.out.println("Error: Salary must be entered as a valid decimal value.");
                sc.nextLine();
            }
        }
        employeeList.add(new Employee(id, name, department, salary));
        System.out.println(" Success: Employee record saved to database!");
    }
    public static void viewAllEmployees(ArrayList<Employee> employeeList) {
        System.out.println("\n--- ALL EMPLOYEE RECORDS ---");
        if (employeeList.isEmpty()) {
            System.out.println("No records found in the database directory.");
            return;
        }

        System.out.printf("%-10s %-22s %-18s %-12s\n", "ID", "Employee Name", "Department", "Salary");
        System.out.println("-".repeat(65));
        for (Employee emp : employeeList) {
            System.out.printf("%-10d %-22s %-18s ₹%,-12.2f\n", emp.id, emp.name, emp.department, emp.salary);
        }
    }
    public static void searchEmployeeById(Scanner sc, ArrayList<Employee> employeeList) {
        System.out.println("\n--- SEARCH EMPLOYEE RECORD ---");
        if (employeeList.isEmpty()) {
            System.out.println("Database is currently empty.");
            return;
        }

        System.out.print("Enter Employee ID to search: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID format entered.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();

        Employee target = findEmployee(employeeList, id);
        if (target != null) {
            System.out.println("\nRecord Found:");
            System.out.println("-".repeat(60));
            System.out.println("ID          : " + target.id);
            System.out.println("Name        : " + target.name);
            System.out.println("Department  : " + target.department);
            System.out.printf("Salary      : $%,.2f\n", target.salary);
            System.out.println("-".repeat(60));
        } else {
            System.out.println(" Record Not Found: No employee found matching ID " + id);
        }
    }
    public static Employee findEmployee(ArrayList<Employee> employeeList, int id) {
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                return emp;
            }
        }
        return null;
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          SYSTEM SHUTDOWN CLEANLY. ALL SESSIONS TERMINATED.");
        System.out.println("=".repeat(60));
    }
}