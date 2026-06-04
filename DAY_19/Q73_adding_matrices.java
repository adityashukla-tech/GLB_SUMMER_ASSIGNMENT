package summer_assignments.DAY_19;
import java.util.*;
public class Q73_adding_matrices {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Columns of the Matrix: ");
        int col=sc.nextInt();
        System.out.print("Enter the Size of Rows of the Matrix: ");
        int row=sc.nextInt();
        if(col<0 || row<0 || col==0||row==0){ System.out.print("Please put positive dimension :"); sc.close(); return;}
        System.out.println();
        System.out.print("Enter the Size of Columns of the Matrix: ");
        int col2=sc.nextInt();
        System.out.print("Enter the Size of Rows of the Matrix: ");
        int row2=sc.nextInt();
        if(col2<0 || row2<0 || col2==0||row2==0){ System.out.print("Please put positive dimension :"); sc.close(); return;}
        if(col!=col2 || row!=row2){
            System.out.print("The Two Matrix Cannot be Added, Enter the Same Dimension");
            sc.close(); return;
        }else {
            int[][] mat1=new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    System.out.print("Enter the Matrix_1 Element at ["+i+","+j+"] Position: ");
                    mat1[i][j]=sc.nextInt();
                }
            }
            int[][] mat2 = new int[row2][col2];
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < col2; j++) {
                    System.out.print("Enter the Matrix_2 Element at [" + i + "," + j + "] Position: ");
                    mat2[i][j] = sc.nextInt();
                }
            }

            int[][] mat3 = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat3[i][j] = mat1[i][j] + mat2[i][j];
                }
            }
            System.out.print("The Resultant Array is: " + Arrays.deepToString(mat3));
            sc.close();
        }
    }
}
