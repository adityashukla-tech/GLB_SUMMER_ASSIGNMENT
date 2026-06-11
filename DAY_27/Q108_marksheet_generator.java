package summer_assignments.DAY_27;
import java.util.*;
public class Q108_marksheet_generator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayHeader();

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine().trim();
        System.out.print("Enter Roll Number: ");
        String rollNumber = sc.nextLine().trim();

        String[] subjects = {"Mathematics", "Physics", "Chemistry", "English", "Computer Science"};
        int[] marks = new int[subjects.length];

        System.out.println("\n" + "-".repeat(40));
        System.out.println("ENTER MARKS OBTAINED (OUT OF 100)");
        System.out.println("-".repeat(40));

        for (int i = 0; i < subjects.length; i++) {
            marks[i] = getValidMark(sc, subjects[i]);
        }

        generateMarksheet(studentName, rollNumber, subjects, marks);
        sc.close();
    }
    public static void displayHeader() {
        System.out.println("=".repeat(60));
        System.out.println("                   STUDENT MARKSHEET GENERATOR");
        System.out.println("=".repeat(60));
    }
    public static int getValidMark(Scanner sc, String subject) {
        while (true) {
            System.out.print(subject + " : ");
            if (sc.hasNextInt()) {
                int mark = sc.nextInt();
                sc.nextLine();
                if (mark >= 0 && mark <= 100) {
                    return mark;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Invalid Entry! Marks must be an integer between 0 and 100.");
        }
    }
    public static String calculateGrade(double percentage, boolean passedAll) {
        if (!passedAll) return "F (Fail)";
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        if (percentage >= 40) return "E";
        return "F (Fail)";
    }
    public static void generateMarksheet(String name, String roll, String[] subjects, int[] marks) {
        int totalMarks = 0;
        boolean passedAllSubjects = true;

        for (int mark : marks) {
            totalMarks += mark;
            if (mark < 40) {
                passedAllSubjects = false;
            }
        }

        double percentage = (double) totalMarks / subjects.length;
        String division = passedAllSubjects ? "PASS" : "FAIL";

        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    ACADEMIC MARKSHEET REPORT");
        System.out.println("=".repeat(60));
        System.out.printf(" Name        : %-30s\n", name);
        System.out.printf(" Roll Number : %-30s\n", roll);
        System.out.println("-".repeat(60));
        System.out.printf(" %-25s | %-15s | %-10s\n", "SUBJECT", "MARKS OBTAINED", "STATUS");
        System.out.println("-".repeat(60));

        for (int i = 0; i < subjects.length; i++) {
            String status = marks[i] >= 40 ? "Pass" : "Fail";
            System.out.printf(" %-25s | %-15d | %-10s\n", subjects[i], marks[i], status);
        }

        System.out.println("-".repeat(60));
        System.out.printf(" Aggregate Total : %-10d / %d\n", totalMarks, (subjects.length * 100));
        System.out.printf(" Percentage      : %.2f%%\n", percentage);
        System.out.printf(" Final Grade     : %-10s\n", calculateGrade(percentage, passedAllSubjects));
        System.out.printf(" Result Status   : %-10s\n", division);
        System.out.println("=".repeat(60));
    }
}