package summer_assignments.DAY_22;
import java.util.*;
public class Q85_palindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the Sentence: ");
        String str=sc.nextLine();
        str=str.replace(" ","");
        String red="";
        if(str.isEmpty()){ System.out.print("Please enter a Sentence: ");
            sc.close(); return ; }
        else {
            for (int i = str.length() - 1; i >= 0; i--) {
                char ch = str.charAt(i);
                red += ch;
            }
        }
        if (str.equalsIgnoreCase(red)){
            System.out.print("It is Palindrome");
        }
        else{ System.out.print("It is NOT Palindrome");}
        sc.close();
    }
}
