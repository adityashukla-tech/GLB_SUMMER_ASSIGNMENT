package summer_assignments.DAY_16;
import java.util.*;
public class Q61_missing_number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element: ");
            arr[i]=sc.nextInt();
        }
        int xorsum=size+1;
        for(int i=0;i<size;i++){
            int ex=i+1;
            int act=arr[i];
            xorsum=xorsum^ex^act;
        }
        System.out.print("The Missing Number is : "+xorsum);
        sc.close();
    }
}
