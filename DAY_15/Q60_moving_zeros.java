package summer_assignments.DAY_15;
import java.util.*;
public class Q60_moving_zeros {
    public static void main(String[] str){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element: ");
            arr[i]=sc.nextInt();
        }
        int zero=0;
        for(int i=0;i<size;i++){
            if(arr[i]!=0){
                arr[zero]=arr[i];
                zero++;
            }
        }
        while (zero<size){
            arr[zero]=0;
            zero++;
        }
        System.out.print("The Array is: ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
