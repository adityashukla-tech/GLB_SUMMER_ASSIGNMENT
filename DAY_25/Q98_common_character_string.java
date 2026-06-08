package summer_assignments.DAY_25;
import java.util.*;
public class Q98_common_character_string {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=sc.nextLine();
        System.out.print("Duplicate Character: ");
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(str.indexOf(ch)==i && str.indexOf(ch,i+1)!=-1){
                System.out.print(ch+" ");
            }
        }
        sc.close();
    }
}
