package summer_assignments.DAY_24;
import java.util.*;
public class Q93_check_string_rotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str1 = sc.nextLine();
        System.out.println("Enter the String: ");
        String str2 = sc.nextLine();
        if (isrotation(str1, str2)) {
            System.out.println("The Word: " + str1 + " is a valid rotation of the word: " + str2);
        } else {
            System.out.println("The Word: " + str1 + " is NOT a valid rotation of the word: " + str2);
        }
        sc.close();
    }
    public static boolean isrotation(String wd1,String wd2){
        if(wd1==null||wd2==null||wd1.length()!=wd2.length()){ return false;}
        String combine=wd1+wd1;
        return combine.contains(wd2);
    }
}
