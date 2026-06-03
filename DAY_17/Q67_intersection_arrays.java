package summer_assignments.DAY_17;
import java.util.*;
public class Q67_intersection_arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of 1st Array: ");
        int size = sc.nextInt();
        System.out.print("Enter the Size of 2nd Array: ");
        int size2 = sc.nextInt();
        int[] a1 = new int[size];
        int[] a2 = new int[size2];
        int[] merge = new int[Math.min(size,size2)];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the " + i + " Element of 1st Array: ");
            a1[i] = sc.nextInt();
        }
        for (int i = 0; i < size2; i++) {
            System.out.print("Enter the " + i + " Element of the 2nd Array: ");
            a2[i] = sc.nextInt();
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int i=0,j=0,count=0;
        while(i<size && j<size2){
            if(a1[i]<a2[j]){
                i++;
            } else if(a1[i]>a2[j]){
                j++;
            }else {
                if(count==0 || merge[count-1]!=a1[i]){
                    merge[count]=a1[i];
                    count++;
                }
                i++;
                j++;
            }
        }
          int[] result = new int[count];
        System.arraycopy(merge,0,result,0,count);
        System.out.print("The Resultant Array is : "+ Arrays.toString(result));
        sc.close();
    }
}
