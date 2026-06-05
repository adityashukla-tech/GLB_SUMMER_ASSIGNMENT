package summer_assignments.DAY_21;
import java.util.*;
public class Q82_reverse_string {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str= sc.nextLine();
        String rwd="";
        for(int i=str.length()-1;i>=0;i--){
            rwd+=str.charAt(i);
        }
        System.out.print("The Reverse String is: "+rwd);
        sc.close();
    }
}
