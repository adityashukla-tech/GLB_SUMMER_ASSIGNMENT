package summer_assignments.DAY_17;
import java.util.*;
public class Q65_merge_array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the First Array: ");
        int size=sc.nextInt();
        System.out.print("Enter the Size of the Second Array: ");
        int size2=sc.nextInt();
        int[] a1=new int[size];
        int[] a2=new int[size2];
        int[] merge=new int[a1.length+a2.length];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element of 1st Array: ");
            a1[i]=sc.nextInt();
        }
        for(int i=0;i<size2;i++){
            System.out.print("Enter the "+i+" Element of the 2nd Array: ");
            a2[i]=sc.nextInt();
        }
        for(int i=0;i<size;i++){
            merge[i]=a1[i];
        }
        for(int i=0;i<size2;i++){
            merge[size+i]=a2[i];
        }
        System.out.print("The Merged Array is: ");
        for(int n: merge){
            System.out.print(n+" ");
        }
        sc.close();
    }
}
/* WE CAN ALSO USE System.arraycopy function.*/