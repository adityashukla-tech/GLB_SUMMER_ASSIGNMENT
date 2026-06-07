package summer_assignments.DAY_24;
import java.util.*;
public class Q95_longest_word {
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the String: ");
    String str=sc.nextLine();
    if(str==null || str.isEmpty()){
        System.out.print("There is NO Longest word");
        sc.close(); return;
    }
    String[] words=str.trim().split("\\s+");
    String longest="";
    for(String wd:words){
        if(wd.length()>longest.length()){
            longest=wd;
        }
    }
     System.out.print("The Longest Word in the Sentence is: "+longest);
    sc.close();
}
}
