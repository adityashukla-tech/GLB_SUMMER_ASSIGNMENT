package summer_assignments.DAY_18;
import java.util.*;
public class Q69_bubble_sort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array: ");
        int size=sc.nextInt();
        int[] arr= new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element of the Array: ");
            arr[i]=sc.nextInt();
        }for(int i=0;i<size-1;i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("The Resultant Array: "+Arrays.toString(arr));
        sc.close();
    }
}
