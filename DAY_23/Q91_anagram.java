package summer_assignments.DAY_23;
import java.util.*;
public class Q91_anagram {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the First Word: ");
        String word1=sc.nextLine().toLowerCase();
        System.out.print("Enter the Second Word: ");
        String word2=sc.nextLine().toLowerCase();
        if(word1.length()!=word2.length()){
            System.out.print("There Are NOT Anagram");
            sc.close(); return;
        }
        char[] ch1=word1.toCharArray();
        char[] ch2=word2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        boolean isAna=true;
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]!=ch2[i]){
                isAna=false;
                break;
            }
        }
        if(isAna){ System.out.print("Both of the Strings are ANAGRAMS"); }
        else { System.out.print("The Strings are NOT Anagrams"); }
        sc.close();
    }
}
