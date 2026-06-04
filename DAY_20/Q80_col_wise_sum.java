package summer_assignments.DAY_20;
import java.util.*;
public class Q80_col_wise_sum {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the Row of the Matrix: ");
        int row=sc.nextInt();
        System.out.print("Enter the Column of the Matrix: ");
        int col=sc.nextInt();
        System.out.println();
        if(row<=0||col<=0){
            System.out.print("Please Enter positive Dimension"); sc.close(); return;
        }
        int[][] mat=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("Enter the ["+i+","+j+"] Element of the Matrix: ");
                mat[i][j]=sc.nextInt();
            }
        }
        for(int j=0;j<col;j++) {
            int sum_co = 0;
            for (int i = 0; i< row; i++) {
                sum_co += mat[i][j];
            }
            System.out.println("The Sum of the Column "+(j+1)+" of the matrix is: "+sum_co);
        }
        System.out.print("The Matrix: "+Arrays.deepToString(mat));
        sc.close();
    }
}
