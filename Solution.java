import java.util.*;

public class Solution {

    public static int longestBalanced(String s) {
        
        int n = s.length();
        int maxLen = 1;  // single character always valid
        
        for (int i = 0; i < n; i++) {
            
            int a = 0, b = 0, c = 0;
            
            for (int j = i; j < n; j++) {
                
                char ch = s.charAt(j);
                
                if (ch == 'a') a++;
                else if (ch == 'b') b++;
                else c++;
                
                // Count distinct characters
                int distinct = 0;
                if (a > 0) distinct++;
                if (b > 0) distinct++;
                if (c > 0) distinct++;
                
                // Check if balanced
                if ((distinct == 1) ||
                    (distinct == 2 && 
                     (a == b || a == c || b == c)) ||
                    (distinct == 3 && a == b && b == c)) {
                    
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter string (only a, b, c):");
        String s = sc.nextLine();
        
        int result = longestBalanced(s);
        
        System.out.println("Longest Balanced Substring Length: " + result);
        
        sc.close();
    }
}
