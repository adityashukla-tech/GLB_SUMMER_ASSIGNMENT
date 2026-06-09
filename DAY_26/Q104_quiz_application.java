package summer_assignments.DAY_26;
import java.util.*;
public class Q104_quiz_application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayWelcomeBanner();
            runQuiz(sc);

            System.out.print("\nWould you like to take the quiz again?\nEnter YES to Restart, NO to EXIT: ");
            String ans = sc.nextLine().trim().toLowerCase();
            if (!ans.equals("yes")) {
                running = false;
            }
        }

        displayExitBanner();
        sc.close();
    }
    public static void displayWelcomeBanner() {
        System.out.println("=".repeat(60));
        System.out.println("                     CORE JAVA MINI QUIZ");
        System.out.println("=".repeat(60));
        System.out.println(" Instructions: Answer all questions by entering the option number (1-4).");
        System.out.println("=".repeat(60));
    }
    public static void runQuiz(Scanner sc) {

        String[] questions = {
                "Which data type is used to create a variable that should store text?",
                "Which method can be used to find the length of a string in Java?",
                "How do you start writing an if statement in Java?",
                "Which operator is used to compare two values for equality?"
        };

        String[][] options = {
                {"1) txt", "2) String", "3) myString", "4) char"},
                {"1) getSize()", "2) len()", "3) length()", "4) getLength()"},
                {"1) if x > y then:", "2) if (x > y)", "3) if x > y:", "4) expression: (x > y)"},
                {"1) =", "2) equals", "3) <>", "4) =="}
        };
        int[] correctAnswers = {2, 3, 2, 4};
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println("   " + option);
            }
            int userAnswer = getValidOption(sc);
            if (userAnswer == correctAnswers[i]) {
                System.out.println(" Correct Answer!");
                score++;
            } else {
                System.out.println("Wrong. The correct option was: " + correctAnswers[i]);
            }
        }
        displayReportCard(score, questions.length);
    }
    public static int getValidOption(Scanner sc) {
        while (true) {
            System.out.print("Your Answer (1-4): ");
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Invalid Selection! Please enter a number between 1 and 4.");
        }
    }
    public static void displayReportCard(int score, int totalQuestions) {
        double percentage = ((double) score / totalQuestions) * 100;

        System.out.println("\n" + "-".repeat(40));
        System.out.println("             QUIZ FINAL REPORT             ");
        System.out.println("-".repeat(40));
        System.out.println(" Total Questions : " + totalQuestions);
        System.out.println(" Correct Answers : " + score);
        System.out.println(" Wrong Answers   : " + (totalQuestions - score));
        System.out.printf(" Final Score     : %.2f%%\n", percentage);
        System.out.print(" Performance     : ");

        if (percentage >= 80) {
            System.out.println("EXCELLENT ");
        } else if (percentage >= 50) {
            System.out.println("GOOD JOB ");
        } else {
            System.out.println("NEEDS REVISION ");
        }
        System.out.println("-".repeat(40));
    }
    public static void displayExitBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          THANK YOU FOR COMPLETING THE QUIZ! EXITING.");
        System.out.println("=".repeat(60));
    }
}