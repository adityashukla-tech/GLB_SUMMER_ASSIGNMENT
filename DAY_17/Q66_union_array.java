package summer_assignments.DAY_17;
import java.util.*;
public class Q66_union_array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of 1st Array: ");
        int size=sc.nextInt();
        System.out.print("Enter the Size of 2nd Array: ");
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
        System.arraycopy(a1,0,merge,0,a1.length);
        System.arraycopy(a2,0,merge,a1.length,a2.length);
        Arrays.sort(merge);
        int count=0;
        int[] temp=new int[merge.length];
        for(int i=0;i<merge.length-1;i++){
            if(merge[i]!=merge[i+1]){
                temp[count]=merge[i];
                count++;
            }
        }
        if(merge.length>0){
            temp[count]=merge[merge.length-1];
            count++;
        }
        int[] result=new int[count];
        for(int i=0;i<count;i++){
            result[i]=temp[i];
        }
        System.out.print("The Union of the Array is: "+Arrays.toString(result));
        sc.close();
    }
}
