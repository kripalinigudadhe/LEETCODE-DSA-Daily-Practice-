import java.util.*;

public class ConcatenatedBinaryNumber {

    public static int concatenatedBinary(int n) {
        long result = 0;
        int mod = 1_000_000_007;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {

            // If i is power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            // Left shift result and add i
            result = ((result << bitLength) % mod + i) % mod;
        }

        return (int) result;
    }

    // -------- PSVM --------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        int answer = concatenatedBinary(n);

        System.out.println("Result: " + answer);

        sc.close();
    }
}