package summer_assignments.DAY_15;
import java.util.*;
public class Q59_rotate_right {
    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the " + i + " Element: ");
            arr[i] = sc.nextInt();
        }
        int temp = arr[size-1];
        for (int i = size-1; i >0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        System.out.print("The Array is: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
