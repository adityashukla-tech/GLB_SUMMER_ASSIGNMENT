package summer_assignments.DAY_16;
import java.util.*;
public class Q63_pair_with_sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element: ");
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the Sum : ");
        int sum = sc.nextInt();
        System.out.print("The Pairs Are: ");
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(arr[i]+arr[j]==sum){
                    System.out.print("("+arr[i]+","+arr[j]+") ");
                }
            }
        }
        sc.close();
    }
}
