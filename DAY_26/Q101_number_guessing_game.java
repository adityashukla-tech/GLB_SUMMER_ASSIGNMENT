package summer_assignments.DAY_26;
import java.util.*;
public class Q101_number_guessing_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        display();
        if (!sc.hasNextInt()) {
            printInvalidOption();
            sc.close();
            return;
        }

        int choice = sc.nextInt();
        sc.nextLine();
        if (choice != 1) {
            System.out.print("=".repeat(60));
            System.out.print("\n" + " ".repeat(7) + "PLEASE ENTER A VALID OPTION NUMBER" + " ".repeat(7));
            System.out.print("\n"+"=".repeat(60));
            sc.close();
            return;
        }
        boolean playing = true;
        while (playing) {
            play(sc);
            System.out.print("\n Would you like to Play Again . \n Enter YES to Continue , NO to EXIT : ");
            String ans = sc.nextLine().trim().toLowerCase();
            if (!ans.equals("yes")) {
                playing = false;
            }
        }
        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(7) + "THANK YOU FOR PLAYING" + " ".repeat(7));
        System.out.println("=".repeat(60));
        sc.close();
    }

    public static void display() {
        System.out.println("=".repeat(60));
        System.out.println("\n" + " ".repeat(7) + "WELCOME TO THE NUMBER GUESSING GAME" + " ".repeat(7));
        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(5) + "PLEASE CHOICE WHICH MODE YOU LIKE TO PLAY");
        System.out.println(" 1) Whole Number. ");
        System.out.println("=".repeat(60));
        System.out.print("Please Enter your Choice here (IN NUMBER) : ");
    }
    public static void play(Scanner sc){
        int guess=new Random().nextInt(101);
        System.out.println("=".repeat(60));
        System.out.println(" ".repeat(7)+"YOU HAVE TO GUESS ANY NUMBER BETWEEN 0 TO 100"+" ".repeat(7));
        System.out.println("=".repeat(60));
        boolean correct=false;
        while(!correct){
            System.out.print("Enter your Guess: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid Input! Please enter a whole number.");
                sc.nextLine();
                continue;
            }
            int gg=sc.nextInt();
            sc.nextLine();
            if(gg==guess) {
                System.out.println("The Result is: CORRECT , CONGRATULATION! ");
                correct = true;
            }else if(gg<guess) {
                System.out.println("The Result is: WRONG , SORRY (Hint: Too Low!)");
            }else {
                System.out.println("The Result is: WRONG , SORRY (Hint: Too High!)");
            }
        }
    }
    public static void printInvalidOption() {
        System.out.print("=".repeat(60));
        System.out.print("\n" + " ".repeat(7) + "PLEASE ENTER A VALID OPTION NUMBER" + " ".repeat(7));
        System.out.print("\n"+"=".repeat(60));
    }
}

