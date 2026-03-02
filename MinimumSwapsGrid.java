import java.util.*;

public class MinimumSwapsGrid {

    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];

        // Step 1: Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = count;
        }

        int swaps = 0;

        // Step 2: Arrange rows
        for (int i = 0; i < n; i++) {
            int requiredZeros = n - i - 1;
            int j = i;

            // Find a row with enough trailing zeros
            while (j < n && trailingZeros[j] < requiredZeros) {
                j++;
            }

            // If no such row found
            if (j == n) {
                return -1;
            }

            // Bring row j up to position i using adjacent swaps
            while (j > i) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }

    // -------- PSVM --------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter grid size (n): ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter grid elements row-wise (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = minSwaps(grid);

        System.out.println("Minimum Swaps Required: " + result);

        sc.close();
    }
}