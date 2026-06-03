package summer_assignments.DAY_18;
import java.util.*;
public class Q70_Selection_sort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Size of the Array: ");
            int size= sc.nextInt();
            int[] arr= new int[size];
            for(int i=0;i<size;i++){
                System.out.print("Enter the "+i+" Element of the Array: ");
                arr[i]=sc.nextInt();
            }
           for(int i=0;i<size-1;i++){
               int min=i;
               for(int j=i+1;j<size;j++){
                   if (arr[j] < arr[min]) {
                       min=j;
                   }
               }
               int temp=arr[min];
               arr[min]=arr[i];
               arr[i]=temp;
           }
           System.out.print("The Resultant Array: "+Arrays.toString(arr));
           sc.close();
    }
}
