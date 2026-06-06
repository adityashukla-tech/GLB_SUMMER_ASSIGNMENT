package summer_assignments.DAY_23;
import java.util.*;
public class Q92_maximum_occurring_character {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=sc.nextLine();
        int[] frq=new int[256];
        for(int i=0;i<str.length();i++){
            frq[str.charAt(i)]++;
        }
        int max=0;
        for(int i=0;i<str.length();i++) {
             if(str.charAt(i)!=' ' && frq[str.charAt(i)]>max){
                 max=frq[str.charAt(i)];
             }
        }
        System.out.print("The Maximum Occurring Character is: ");
        if (max == 0) {
            System.out.print("No valid characters found.");}
        else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch != ' ' && frq[ch] == max) {
                    System.out.print(" '" + ch + "' ");
                    frq[ch] = 0;
                }
            }
        }
         sc.close();
    }
}
