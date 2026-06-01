package summer_assignments.DAY_15;
import java.util.*;
public class Q57_REVERSE_ARRAY {
    public static void main(String[] str){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size: ");
        int size= sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element: ");
            arr[i]=sc.nextInt();
        }
        int left=0,right=size-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        System.out.print("The Reverse Array: ");
        for(int num: arr){
            System.out.print(num+" ");
        }
        sc.close();
    }
}
