import java.util.*;

public class AlternateBits {

    public boolean hasAlternatingBits(int n) {

        String s = Integer.toBinaryString(n);
        int len = s.length();

        for (int i = 0; i < len - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    // PSVM
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        AlternateBits obj = new AlternateBits();  // ✅ Fixed here
        boolean result = obj.hasAlternatingBits(n);

        System.out.println(result);

        sc.close();
    }
}
