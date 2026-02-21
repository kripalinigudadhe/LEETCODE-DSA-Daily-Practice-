import java.util.*;

public class PrimeSetBits {

    public int countPrimeSetBits(int left, int right) {

        int count = 0;

        for (int num = left; num <= right; num++) {

            int setBits = Integer.bitCount(num);

            if (isPrime(setBits)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    // PSVM
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter left: ");
        int left = sc.nextInt();

        System.out.print("Enter right: ");
        int right = sc.nextInt();

        PrimeSetBits obj = new PrimeSetBits();
        int result = obj.countPrimeSetBits(left, right);

        System.out.println("Count = " + result);

        sc.close();
    }
}