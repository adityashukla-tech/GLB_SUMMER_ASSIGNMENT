package summer_assignments.DAY_20;
import java.util.*;
public class Q77_multiply_matrices {
    public static void main(String[] str){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Rows of the Matrix_1: ");
        int row1=sc.nextInt();
        System.out.print("Enter the Column of the Matrix_1: ");
        int col1=sc.nextInt();

        if(row1<=0 || col1<=0){ System.out.print("Please Enter Positive Dimensions: "); sc.close(); return;}
        System.out.println();

        System.out.print("Enter the Rows of the Matrix_2: ");
        int row2=sc.nextInt();
        System.out.print("Enter the Column of the Matrix_2: ");
        int col2=sc.nextInt();
        System.out.println();

        if(row2<=0 || col2<=0){ System.out.print("Please Enter Positive Dimensions: "); sc.close(); return;}
        if(col1!=row2){ System.out.print("Multiplication is NOT Possible: "); sc.close(); return; }

        int[][] mat1=new int[row1][col1];
        int[][] mat2=new int[row2][col2];
        int[][] mat3= new int[row1][col2];

        for(int i=0;i<row1;i++){
            for(int j=0;j<col1;j++){
                System.out.print("Enter the ["+i+","+j+"] Element of the MATRIX_1: ");
                mat1[i][j]=sc.nextInt();
            }
        }
        System.out.println();
        for(int i=0;i<row2;i++){
            for(int j=0;j<col2;j++){
                System.out.print("Enter the ["+i+","+j+"] Element of the MATRIX_2: ");
                mat2[i][j]=sc.nextInt();
            }
        }
        System.out.println();
        for(int i=0;i<row1;i++){
            for(int j=0;j<col2;j++){
                for( int k=0;k<col1;k++){
                    mat3[i][j]+=mat1[i][k]*mat2[k][j];
                }
            }
        }
        System.out.print("The Resultant Matrix: "+Arrays.deepToString(mat3));
        sc.close();
    }
}
