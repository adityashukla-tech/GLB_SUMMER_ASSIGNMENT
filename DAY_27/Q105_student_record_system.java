package summer_assignments.DAY_27;
import java.util.*;
public class Q105_student_record_system {
    static class Student {
        int rollNumber;
        String name;
        double marks;

        Student(int rollNumber, String name, double marks) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.marks = marks;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
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
                    addStudent(sc, studentList);
                    break;
                case 2:
                    viewAllStudents(studentList);
                    break;
                case 3:
                    searchStudentByRoll(sc, studentList);
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
        System.out.println("                 STUDENT RECORD MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.println("1. Add New Student Record");
        System.out.println("2. View All Student Records");
        System.out.println("3. Search Student by Roll Number");
        System.out.println("4. Exit System");
        System.out.println("=".repeat(60));
        System.out.print("Please Select an Operation: ");
    }
    public static void addStudent(Scanner sc, ArrayList<Student> studentList) {
        System.out.println("\n--- ADD NEW STUDENT RECORD ---");
        int roll = -1;
        while (roll <= 0) {
            System.out.print("Enter unique Roll Number (Positive Integer): ");
            if (sc.hasNextInt()) {
                roll = sc.nextInt();
                sc.nextLine();
                if (roll <= 0) {
                    System.out.println("Invalid! Roll number must be greater than 0.");
                } else if (findStudent(studentList, roll) != null) {
                    System.out.println("Error: A student with Roll Number " + roll + " already exists!");
                    roll = -1;
                }
            } else {
                System.out.println("Error: Roll number must be numerical.");
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
                    System.out.println("Invalid! Marks must sit between 0 and 100.");
                }
            } else {
                System.out.println("Error: Marks must be a valid decimal number.");
                sc.nextLine();
            }
        }
        studentList.add(new Student(roll, name, marks));
        System.out.println(" Success: Student record added successfully!");
    }
    public static void viewAllStudents(ArrayList<Student> studentList) {
        System.out.println("\n--- ALL STUDENT RECORDS ---");
        if (studentList.isEmpty()) {
            System.out.println("No records found in the system database.");
            return;
        }
        System.out.printf("%-15s %-25s %-15s\n", "Roll Number", "Student Name", "Marks Obtained");
        System.out.println("-".repeat(55));
        for (Student s : studentList) {
            System.out.printf("%-15d %-25s %-15.2f\n", s.rollNumber, s.name, s.marks);
        }
    }
    public static void searchStudentByRoll(Scanner sc, ArrayList<Student> studentList) {
        System.out.println("\n--- SEARCH STUDENT RECORD ---");
        if (studentList.isEmpty()) {
            System.out.println("Database is currently empty.");
            return;
        }

        System.out.print("Enter Roll Number to search: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input type entered.");
            sc.nextLine();
            return;
        }
        int roll = sc.nextInt();
        sc.nextLine();
        Student target = findStudent(studentList, roll);
        if (target != null) {
            System.out.println("\nRecord Found:");
            System.out.println("-----------------------------------");
            System.out.println("Roll Number : " + target.rollNumber);
            System.out.println("Full Name   : " + target.name);
            System.out.println("Marks       : " + target.marks + "%");
            System.out.println("-----------------------------------");
        } else {
            System.out.println(" Record Not Found: No student matches Roll Number " + roll);
        }
    }
    public static Student findStudent(ArrayList<Student> studentList, int rollNumber) {
        for (Student s : studentList) {
            if (s.rollNumber == rollNumber) {
                return s;
            }
        }
        return null;
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          SYSTEM CLOSED SUCCESSFULLY. HAVE A GREAT DAY!");
        System.out.println("=".repeat(60));
    }
}