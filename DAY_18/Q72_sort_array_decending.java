package summer_assignments.DAY_18;
import java.util.*;
public class Q72_sort_array_decending {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element: ");
            arr[i]=sc.nextInt();
        }
        int i,j;
        for(i=0;i<size-1;i++){
            for(j=i+1;j<size;j++){
                if(arr[i]<arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        System.out.print("The Array is: "+Arrays.toString(arr));
        sc.close();
    }
}
