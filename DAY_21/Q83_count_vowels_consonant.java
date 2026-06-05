package summer_assignments.DAY_21;
import java.util.*;
public class Q83_count_vowels_consonant {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=sc.nextLine().toUpperCase();
        int cv=0,cc=0;
        char ch;
            for(int i=0;i<str.length();i++){
                ch=str.charAt(i);
                if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                    cv++;
                }else if(ch>='A' && ch<='Z'){
                    cc++;}
            }

        System.out.println("The Number of Vowels: "+cv);
        System.out.print("The Number of Consonant: "+cc);
        sc.close();
}
}

