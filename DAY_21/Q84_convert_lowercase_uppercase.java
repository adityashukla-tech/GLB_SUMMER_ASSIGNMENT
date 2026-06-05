package summer_assignments.DAY_21;
import java.util.*;
public class Q84_convert_lowercase_uppercase {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Sentence: ");
        String str=sc.nextLine();
        char ch;
        String temp="";
        for(int i=0;i<str.length();i++){
            ch= str.charAt(i);
            if(ch>=97 && ch<=122){
                temp+=(char)(ch-32);
            }else if(ch>=65 && ch<=90){temp+=(char)(ch+32);}
            else { temp+=ch; }
        }
        System.out.print("The New String is: "+temp);
        sc.close();
    }
}
