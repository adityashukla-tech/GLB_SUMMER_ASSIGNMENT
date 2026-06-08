package summer_assignments.DAY_25;
import java.util.*;
public class Q97_merge_sorted_array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array_1: ");
        int size1=sc.nextInt();
        System.out.println();
        System.out.print("Enter the Size of the Array_2: ");
        int size2=sc.nextInt();

        while(size1<0||size2<0){ System.out.print("Please Enter Valid Size: ");
            System.out.print("Enter the Size of the Array_1: ");
             size1=sc.nextInt();
             System.out.println();
            System.out.print("Enter the Size of the Array_2: ");
             size2=sc.nextInt();
        }

        if(size1==0 && size2==0){ System.out.print("There Are No Element in the Arrays: "); sc.close(); return; }
        int[] mat1=new int[size1];
        int[] mat2=new int[size2];

        System.out.println();
        for(int i=0;i<size1;i++){
            System.out.print("Enter the "+i+" Element of the Array_1: ");
            mat1[i]=sc.nextInt();
        }
        for(int i=0;i<size2;i++){
            System.out.print("Enter the "+i+" Element of the Array_2: ");
            mat2[i]=sc.nextInt();
        }
        for(int i=0; i<size1-1; i++){
            for(int j=i+1; j<size1; j++){
                if(mat1[i] > mat1[j]){
                    int temp=mat1[i];
                    mat1[i]=mat1[j];
                    mat1[j]=temp;
                }
            }
        }
        for(int i=0; i<size2-1; i++){
            for(int j=i+1; j<size2; j++){
                if(mat2[i] > mat2[j]){
                    int temp=mat2[i];
                    mat2[i]=mat2[j];
                    mat2[j]=temp;
                }
            }
        }
        int i=0,j=0,k=0;
        int[] result=new int[mat1.length+mat2.length];
        while(i<size1 && j<size2){
            if(mat1[i]<=mat2[j]){
                result[k++]=mat1[i++];
            }
            else {
                result[k++]=mat2[j++];
            }
        }
        while (i < size1) {
            result[k++] = mat1[i++];
        }
        while (j < size2) {
            result[k++] = mat2[j++];
        }
        System.out.print("\nThe Sorted Array_1: "+Arrays.toString(mat1));
        System.out.print("\nThe Sorted Array_2: "+Arrays.toString(mat2));
        System.out.print("\nThe Merged Sorted Array is : "+Arrays.toString(result));
        sc.close();
    }
}
