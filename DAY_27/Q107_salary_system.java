package summer_assignments.DAY_27;
import java.util.*;
public class Q107_salary_system {
    static class SalarySlip {
        int empId;
        String name;
        double basicSalary;
        double hra;
        double da;
        double pf;
        double tax;
        double grossSalary;
        double netSalary;

        SalarySlip(int empId, String name, double basicSalary) {
            this.empId = empId;
            this.name = name;
            this.basicSalary = basicSalary;

            this.hra = basicSalary * 0.20;
            this.da = basicSalary * 0.15;
            this.pf = basicSalary * 0.12;

            this.grossSalary = this.basicSalary + this.hra + this.da;
            if (this.grossSalary > 100000) {
                this.tax = this.grossSalary * 0.20;
            } else if (this.grossSalary > 50000) {
                this.tax = this.grossSalary * 0.10;
            } else {
                this.tax = 0;
            }

            this.netSalary = this.grossSalary - (this.pf + this.tax);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SalarySlip> payrollList = new ArrayList<>();
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
                    generateSalarySlip(sc, payrollList);
                    break;
                case 2:
                    viewPayrollRegister(payrollList);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid Option! Please select a choice from 1 to 3.");
            }
        }
        displayExitBanner();
        sc.close();
    }
    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                     PAYROLL & SALARY SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Generate New Employee Salary Slip");
        System.out.println("2. View Comprehensive Payroll Register");
        System.out.println("3. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }
    public static void generateSalarySlip(Scanner sc, ArrayList<SalarySlip> payrollList) {
        System.out.println("\n--- GENERATE SALARY SLIP ---");
        int id = -1;
        while (id <= 0) {
            System.out.print("Enter Employee ID: ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                if (id <= 0) System.out.println("ID must be greater than 0.");
            } else {
                System.out.println("Error: Employee ID must be an integer.");
                sc.nextLine();
            }
        }
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine().trim();
        double basicSalary = -1;
        while (basicSalary < 0) {
            System.out.print("Enter Monthly Basic Salary (₹): ");
            if (sc.hasNextDouble()) {
                basicSalary = sc.nextDouble();
                sc.nextLine();
                if (basicSalary < 0) System.out.println("Salary cannot be negative.");
            } else {
                System.out.println("Error: Please input a valid decimal value.");
                sc.nextLine();
            }
        }

        SalarySlip slip = new SalarySlip(id, name, basicSalary);
        payrollList.add(slip);

        printIndividualSlip(slip);
    }
    public static void printIndividualSlip(SalarySlip slip) {
        System.out.println("\n" + "-".repeat(45));
        System.out.println("              EARNINGS STATEMENT             ");
        System.out.println("-".repeat(45));
        System.out.printf("Employee ID   : %d\n", slip.empId);
        System.out.printf("Voter Name    : %s\n", slip.name);
        System.out.println("-".repeat(45));
        System.out.printf("  (+) Basic Salary   : ₹%,12.2f\n", slip.basicSalary);
        System.out.printf("  (+) HRA Allowance  : ₹%,12.2f\n", slip.hra);
        System.out.printf("  (+) DA Allowance   : ₹%,12.2f\n", slip.da);
        System.out.printf("  (=) GROSS SALARY   : ₹%,12.2f\n", slip.grossSalary);
        System.out.println("-".repeat(45));
        System.out.printf("  (-) PF Deduction   : ₹%,12.2f\n", slip.pf);
        System.out.printf("  (-) Income Tax     : ₹%,12.2f\n", slip.tax);
        System.out.println("-".repeat(45));
        System.out.printf("  (=) NET TAKE-HOME  : ₹%,12.2f\n", slip.netSalary);
        System.out.println("-".repeat(45));
    }
    public static void viewPayrollRegister(ArrayList<SalarySlip> payrollList) {
        System.out.println("\n--- COMPREHENSIVE PAYROLL REGISTER ---");
        if (payrollList.isEmpty()) {
            System.out.println("No salary actions recorded for the active processing cycle.");
            return;
        }
        System.out.printf("%-8s %-20s %-14s %-14s %-14s\n", "ID", "Name", "Gross Pay", "Deductions", "Net Take-Home");
        System.out.println("-".repeat(75));
        for (SalarySlip slip : payrollList) {
            double totalDeductions = slip.pf + slip.tax;
            System.out.printf("%-8d %-20s ₹%,-13.2f ₹%,-13.2f ₹%,-13.2f\n",
                    slip.empId, slip.name, slip.grossSalary, totalDeductions, slip.netSalary);
        }
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          PAYROLL ENGINE CLOSED. DATA SEQUENTIALLY CONSOLIDATED.");
        System.out.println("=".repeat(60));
    }
}