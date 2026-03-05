class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        int startWithZero = 0; // Pattern: 010101...
        int startWithOne = 0;  // Pattern: 101010...
        
        for (int i = 0; i < n; i++) {
            char expectedZero = (i % 2 == 0) ? '0' : '1';
            char expectedOne  = (i % 2 == 0) ? '1' : '0';
            
            if (s.charAt(i) != expectedZero) {
                startWithZero++;
            }
            
            if (s.charAt(i) != expectedOne) {
                startWithOne++;
            }
        }
        
        return Math.min(startWithZero, startWithOne);
    }
}