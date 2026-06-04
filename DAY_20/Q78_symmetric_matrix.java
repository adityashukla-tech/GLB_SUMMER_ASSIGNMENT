package summer_assignments.DAY_20;
import java.util.*;
public class Q78_symmetric_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Rows of the Matrix: ");
        int row = sc.nextInt();
        System.out.print("Enter the Columns of the Matrix: ");
        int col = sc.nextInt();
        if (row <= 0 || col <= 0) {
            System.out.print("Please Enter Positive Dimensions.");
            sc.close();
            return;
        }
        if (row != col) {
            System.out.print("The Matrix is NOT symmetric (It must be a Square Matrix).");
            sc.close();
            return;
        }
        int[][] mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter the [" + i + "," + j + "] Element of the MATRIX: ");
                mat[i][j] = sc.nextInt();
            }
        }
        boolean isSymmetric = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                if (mat[i][j] != mat[j][i]) {
                    isSymmetric = false;
                    break;
                }
            }
            if (!isSymmetric) {
                break;
            }
        }
        System.out.println("Your Matrix: " + Arrays.deepToString(mat));
        if (isSymmetric) {
            System.out.println("Result: The Matrix IS Symmetric.");
        } else {
            System.out.println("Result: The Matrix is NOT Symmetric.");
        }
        sc.close();
    }
}