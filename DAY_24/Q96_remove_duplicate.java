package summer_assignments.DAY_24;
import java.util.*;
public class Q96_remove_duplicate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Sentence: ");
        String str=sc.nextLine();
        StringBuilder result=new StringBuilder();
        String lower=str.toLowerCase();
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch==' '||ch=='\t'||ch=='\n'){
                continue;
            }
            char lowerch=Character.toLowerCase(ch);
            if(lower.indexOf(lowerch)==i){
                   result.append(ch).append(" ");
            }
        }
        System.out.print("the Resultant String is: "+result.toString());
        sc.close();
    }
}


