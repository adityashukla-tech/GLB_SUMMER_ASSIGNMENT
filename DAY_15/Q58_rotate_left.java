package summer_assignments.DAY_15;
import java.util.*;
public class Q58_rotate_left {
    public static void main(String[] str){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element: ");
            arr[i]=sc.nextInt();
        }
        int temp=arr[0];
        for(int i=0;i<size-1;i++){
            arr[i]=arr[i+1];
        }
        arr[size-1]=temp;
        System.out.print("The Array is: ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

}
