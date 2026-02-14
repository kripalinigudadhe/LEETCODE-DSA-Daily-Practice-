import java.util.*;

public class substring {

    public static int longestBalancedSubstring(String s) {

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                char ch = s.charAt(j);
                freq[ch - 'a']++;

                int minFreq = Integer.MAX_VALUE;
                int maxFreq = 0;

                // Check frequencies of distinct characters
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        minFreq = Math.min(minFreq, freq[k]);
                        maxFreq = Math.max(maxFreq, freq[k]);
                    }
                }

                // Balanced condition
                if (minFreq == maxFreq) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    // PSVM (Main Method)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string:");
        String s = sc.nextLine();

        int result = longestBalancedSubstring(s);

        System.out.println("Longest Balanced Substring Length: " + result);

        sc.close();
    }
}
