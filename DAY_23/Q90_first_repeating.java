package summer_assignments.DAY_23;
import java.util.*;
public class Q90_first_repeating {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Sentence: ");
        String str= sc.nextLine();
        char result='\0';
        for(int i=0;i<str.length();i++){
            boolean isSame=false;
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    isSame=true;
                    break;
                }
            }
            if(isSame){
                result=str.charAt(i);
                break;
            }
        }
        if(result!='\0'){
            System.out.print("The First  Repeating Character: "+result);
        }else{
            System.out.print("No Character Repeat");}
        sc.close();
    }
}
