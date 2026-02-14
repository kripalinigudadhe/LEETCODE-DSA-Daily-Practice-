import java.util.Scanner;

public class ChampagneTower {

    public static double champagneTower(int poured, int query_row, int query_glass) {
        
        // Create DP table (max 100 rows as per constraint)
        double[][] tower = new double[100][100];
        
        // Pour champagne into top glass
        tower[0][0] = poured;
        
        // Process row by row
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                
                // If glass overflows
                if (tower[i][j] > 1.0) {
                    double excess = tower[i][j] - 1.0;
                    
                    // Distribute overflow equally
                    tower[i + 1][j] += excess / 2.0;
                    tower[i + 1][j + 1] += excess / 2.0;
                    
                    // Current glass remains full
                    tower[i][j] = 1.0;
                }
            }
        }
        
        // Glass can hold maximum 1
        return Math.min(1.0, tower[query_row][query_glass]);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Take input
        System.out.print("Enter poured: ");
        int poured = sc.nextInt();
        
        System.out.print("Enter query_row: ");
        int query_row = sc.nextInt();
        
        System.out.print("Enter query_glass: ");
        int query_glass = sc.nextInt();
        
        // Call function
        double result = champagneTower(poured, query_row, query_glass);
        
        // Print result upto 5 decimal places
        System.out.printf("Output: %.5f\n", result);
        
        sc.close();
    }
}
