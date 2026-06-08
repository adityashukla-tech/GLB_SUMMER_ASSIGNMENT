package summer_assignments.DAY_25;
import java.util.*;
public class Q100_sort_word_by_length {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=sc.nextLine();
        String sanitized=str.replaceAll("[^a-zA-Z0-9\\s]","").trim();
        if (sanitized.isEmpty()) {
            System.out.println("The Resultant Array: []");
            sc.close();
            return;
        }
        String[] words=sanitized.split("\\s+");
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].length()>words[j].length()){
                    String temp=words[i];
                    words[i]=words[j];
                    words[j]=temp;
                }
            }
        }
        System.out.print("The Resultant Array: "+Arrays.toString(words));
        sc.close();
    }
}
