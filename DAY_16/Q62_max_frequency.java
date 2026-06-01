package summer_assignments.DAY_16;
import java.util.*;
public class Q62_max_frequency {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element: ");
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int maxfrq=1;
        int maxnum=arr[0],current=1;
        for(int i=1;i<size;i++) {
            if (arr[i] == arr[i - 1]) {
                current++;
            } else {
                if (current > maxfrq) {
                    maxfrq = current;
                    maxnum = arr[i - 1];
                }
                current = 1;
            }
        }
            if(current>maxfrq){
                maxfrq=current;
                maxnum=arr[size-1]; }
            System.out.println("The MAX Frequency Number is =  "+maxnum);
        System.out.print("The MAX Frequency is =  "+maxfrq);
    }
}
