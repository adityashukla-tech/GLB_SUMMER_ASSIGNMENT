package summer_assignments.DAY_22;
import java.util.*;
public class Q88_remove_spaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Sentence: ");
        String str = sc.nextLine();
        String temp="";
        if(str.isEmpty()){System.out.print("NO Spaces present: ");
            sc.close(); return;}
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                    temp += str.charAt(i);
            }
        }
        System.out.print("The New string: "+temp);
        sc.close();
    }
}
