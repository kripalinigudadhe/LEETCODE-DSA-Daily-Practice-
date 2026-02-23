import java.util.*;

public class CheckBinaryCodes {

    public boolean hasAllCodes(String s, int k) {

        int total = 1 << k;  // 2^k
        boolean[] seen = new boolean[total];
        int count = 0;
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            // Shift left and keep only last k bits
            num = ((num << 1) & (total - 1)) | (s.charAt(i) - '0');

            // Start checking only when we have at least k bits
            if (i >= k - 1 && !seen[num]) {
                seen[num] = true;
                count++;

                if (count == total) {
                    return true;
                }
            }
        }

        return false;
    }

    // PSVM
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        CheckBinaryCodes obj = new CheckBinaryCodes();
        boolean result = obj.hasAllCodes(s, k);

        System.out.println("Result: " + result);

        sc.close();
    }
}