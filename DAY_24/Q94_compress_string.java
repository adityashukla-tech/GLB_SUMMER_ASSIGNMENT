package summer_assignments.DAY_24;
import java.util.*;
public class Q94_compress_string {
    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 1;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String1 for the Test: ");
        String test1 = sc.nextLine();
        System.out.println("Original: " + test1);
        System.out.println("Compressed: " + compressString(test1));
        System.out.println("---------------------------------");
        System.out.print("Enter the String2 for the Test: ");
        String test2 = sc.nextLine();
        System.out.println("Original: " + test2);
        System.out.println("Compressed: " + compressString(test2));
    }
}