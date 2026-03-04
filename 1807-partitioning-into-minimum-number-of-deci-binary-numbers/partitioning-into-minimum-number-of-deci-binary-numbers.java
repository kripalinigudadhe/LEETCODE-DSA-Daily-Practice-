class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            maxDigit = Math.max(maxDigit, digit);
            
            // Early exit: if 9 found, answer must be 9
            if (maxDigit == 9) {
                return 9;
            }
        }
        
        return maxDigit;
    }
}