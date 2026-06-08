package summer_assignments.DAY_25;
import java.util.*;
public class Q99_sorting_names_alphabetically {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Naming List: ");
        int size=sc.nextInt();
        sc.nextLine();
        String[] arr=new String[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+(i+1)+" Name in the List: ");
            arr[i]=sc.nextLine();
        }
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(arr[i].compareToIgnoreCase(arr[j])>0){
                    String temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("The Result List: "+Arrays.toString(arr));
        sc.close();
    }
}
