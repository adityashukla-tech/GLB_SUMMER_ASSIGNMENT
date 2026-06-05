package summer_assignments.DAY_22;
import java.util.*;
public class Q87_character_frequency {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Sentence: ");
        String str=sc.nextLine();
        int ch_fq=0;
        char ch;
        if(str.isEmpty()){ System.out.print("There is NO Character: ");
            sc.close(); return ; }
        System.out.print("Enter the Character you like to find the Frequency of: ");
        String target = sc.nextLine();
        if (target.isEmpty()) {
            System.out.print("The Character Frequency is : 0");
            sc.close();
            return;
        }
        char tt=target.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == tt) {
                    ch_fq++;
            }
        }
        System.out.print("The Character Frequency is : "+ch_fq);
        sc.close();
    }
}
