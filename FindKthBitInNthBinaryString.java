import java.util.*;

public class FindKthBitInNthBinaryString {

    public static char findKthBit(int n, int k) {
        // Base case
        if (n == 1) {
            return '0';
        }

        int length = (1 << n) - 1;  // 2^n - 1
        int mid = (length / 2) + 1;

        // If k is the middle element
        if (k == mid) {
            return '1';
        }

        // If k is in left half
        if (k < mid) {
            return findKthBit(n - 1, k);
        } 
        // If k is in right half
        else {
            int newK = length - k + 1;
            char bit = findKthBit(n - 1, newK);

            // Invert the bit
            return bit == '0' ? '1' : '0';
        }
    }

    // -------- PSVM --------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        char result = findKthBit(n, k);

        System.out.println("The " + k + "th bit in S" + n + " is: " + result);

        sc.close();
    }
}