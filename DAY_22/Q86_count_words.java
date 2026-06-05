package summer_assignments.DAY_22;
import java.util.*;
public class Q86_count_words {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Sentence: ");
        String str= sc.nextLine().trim();
        int wordcount=1;
        if(str.isEmpty()){
        System.out.print("There are ZERO words: "); sc.close(); return;}
        char ch;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==' '&& str.charAt(i+1)!=' '){
                wordcount++;
            }
        }
        System.out.println("The Sentence is : "+str);
        System.out.print("The Number of word in the Sentence is : "+wordcount);
        sc.close();
    }
}
