package summer_assignments.DAY_19;
import java.util.*;
public class Q75_Transpose_matrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Row size of the Array: ");
        int row= sc.nextInt();
        System.out.print("Enter the Column Size of the Array: ");
        int col= sc.nextInt();
        if(col<0 || row<0 || col==0||row==0){ System.out.print("Please put positive dimension :"); sc.close(); return;}
        int[][] mat=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("Enter the ["+i+","+j+"] Element: ");
                mat[i][j]=sc.nextInt();
            }
        }
        int[][] result=new int[col][row];
        for(int i=0;i<row;i++){
            for( int j=0;j<col;j++){
               result[j][i]=mat[i][j];
            }
        }
       System.out.print("The Resultant Matrix: "+Arrays.deepToString(result));
        sc.close();
    }
}
