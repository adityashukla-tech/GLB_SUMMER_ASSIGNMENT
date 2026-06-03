package summer_assignments.DAY_18;
import java.util.*;
public class Q71_binary_search {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array: ");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" Element: ");
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("The Sorted Array is : "+Arrays.toString(arr));
        System.out.print("Enter the Number you would like to search: ");
        int search=sc.nextInt();
        int high=size-1,low=0,mid,result=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            if(arr[mid]==search){
                result=mid;
                break;
            }
            else if(arr[mid]>search){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        if(result!=-1){
            System.out.print("The Number was found on the position: "+result);
        }
        else {System.out.print("No Number was Found");}
        sc.close();
    }
}
