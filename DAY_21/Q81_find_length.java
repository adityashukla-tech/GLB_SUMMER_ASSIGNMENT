package summer_assignments.DAY_21;
import java.util.*;
public class Q81_find_length {
    public static void main(String[] str){
        Scanner sc = new Scanner(System.in);
       System.out.print("Enter the String: ");
        String st=sc.nextLine();
        int length=0;
        char[] ch=st.toCharArray();
        for(char c:ch){
            length++;
        }
        System.out.print("The Length of the String is: "+length);
        sc.close();
    }
}
