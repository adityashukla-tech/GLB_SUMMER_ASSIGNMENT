package summer_assignments.DAY_30;
import java.util.*;
public class Q117_student_record_system_array_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxCapacity = 100;
        int[] rollNumbers = new int[maxCapacity];
        String[] names = new String[maxCapacity];
        double[] marksArray = new double[maxCapacity];
        int studentCount = 0;

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
                    if (studentCount >= maxCapacity) {
                        System.out.println("\nError: Database capacity reached. Cannot add more records.");
                    } else {
                        studentCount = addStudent(sc, rollNumbers, names, marksArray, studentCount);
                    }
                    break;
                case 2:
                    viewAllStudents(rollNumbers, names, marksArray, studentCount);
                    break;
                case 3:
                    searchStudentByRoll(sc, rollNumbers, names, marksArray, studentCount);
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
        System.out.println("             STUDENT ARRAY RECORD MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Add New Student Record");
        System.out.println("2. View All Student Records");
        System.out.println("3. Search Student by Roll Number");
        System.out.println("4. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }

    public static int addStudent(Scanner sc, int[] rollNumbers, String[] names, double[] marksArray, int studentCount) {
        System.out.println("\n--- ADD NEW STUDENT RECORD ---");
        int roll = -1;

        while (roll <= 0) {
            System.out.print("Enter Unique Roll Number (Positive Integer): ");
            if (sc.hasNextInt()) {
                roll = sc.nextInt();
                sc.nextLine();

                if (roll <= 0) {
                    System.out.println("Invalid! Roll number must be greater than 0.");
                } else if (findStudentIndex(rollNumbers, studentCount, roll) != -1) {
                    System.out.println("Error: A student with Roll Number " + roll + " already exists!");
                    roll = -1;
                }
            } else {
                System.out.println("Error: Roll number must be a valid whole number.");
                sc.nextLine();
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        double marks = -1;
        while (marks < 0 || marks > 100) {
            System.out.print("Enter Marks (0.0 to 100.0): ");
            if (sc.hasNextDouble()) {
                marks = sc.nextDouble();
                sc.nextLine();
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid! Marks must be inside the range of 0 to 100.");
                }
            } else {
                System.out.println("Error: Marks must be entered as a valid decimal number.");
                sc.nextLine();
            }
        }

        rollNumbers[studentCount] = roll;
        names[studentCount] = name;
        marksArray[studentCount] = marks;

        System.out.println("Success: Student record saved down into the array storage!");
        return studentCount + 1;
    }

    public static void viewAllStudents(int[] rollNumbers, String[] names, double[] marksArray, int studentCount) {
        System.out.println("\n--- ALL STUDENT RECORDS ---");
        if (studentCount == 0) {
            System.out.println("No records found in the system database.");
            return;
        }

        System.out.printf("%-15s %-25s %-15s\n", "Roll Number", "Student Name", "Marks Obtained");
        System.out.println("-".repeat(55));
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-15d %-25s %-15.2f\n", rollNumbers[i], names[i], marksArray[i]);
        }
    }

    public static void searchStudentByRoll(Scanner sc, int[] rollNumbers, String[] names, double[] marksArray, int studentCount) {
        System.out.println("\n--- SEARCH STUDENT RECORD ---");
        if (studentCount == 0) {
            System.out.println("Database is currently empty.");
            return;
        }

        System.out.print("Enter Roll Number to search: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input format entered.");
            sc.nextLine();
            return;
        }
        int roll = sc.nextInt();
        sc.nextLine();

        int index = findStudentIndex(rollNumbers, studentCount, roll);
        if (index != -1) {
            System.out.println("\nRecord Found:");
            System.out.println("-".repeat(45));
            System.out.println("Roll Number : " + rollNumbers[index]);
            System.out.println("Full Name   : " + names[index]);
            System.out.printf("Marks       : %.2f%%\n", marksArray[index]);
            System.out.println("-".repeat(45));
        } else {
            System.out.println("Record Not Found: No student matches Roll Number " + roll);
        }
    }

    public static int findStudentIndex(int[] rollNumbers, int studentCount, int rollNumber) {
        for (int i = 0; i < studentCount; i++) {
            if (rollNumbers[i] == rollNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          ARRAY TERMINAL DEACTIVATED. APPLICATION TERMINATED.");
        System.out.println("=".repeat(60));
    }
}