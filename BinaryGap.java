import java.util.*;

public class BinaryGap {

    public int binaryGap(int n) {
        int maxDistance = 0;
        int lastPosition = -1;
        int position = 0;

        while (n > 0) {

            if ((n & 1) == 1) {   // Check if last bit is 1

                if (lastPosition != -1) {
                    maxDistance = Math.max(maxDistance, position - lastPosition);
                }

                lastPosition = position;
            }

            n = n >> 1;  // Right shift
            position++;
        }

        return maxDistance;
    }

    // PSVM
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        BinaryGap obj = new BinaryGap();
        int result = obj.binaryGap(n);

        System.out.println("Longest Binary Gap: " + result);

        sc.close();
    }
}