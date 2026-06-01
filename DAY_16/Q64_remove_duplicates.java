package summer_assignments.DAY_16;
import java.util.*;
public class Q64_remove_duplicates {
    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the " + i + " Element: ");
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] temp=new int[size];
        int count=0;
        for(int i=0;i<size-1;i++){
            if(arr[i]!=arr[i+1]){
                temp[count]=arr[i];
                count++;
            }
        }
        temp[count]=arr[size-1];
        count++;
        int[] result=new int[count];
        for(int i=0;i<count;i++){
            result[i]=temp[i];
        }
        System.out.print("The Resultant Array is : ");
        for(int n:result){
            System.out.print(n+" ");
        }
        sc.close();
    }
}
