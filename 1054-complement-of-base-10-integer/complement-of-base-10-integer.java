class Solution {
    public int bitwiseComplement(int n) {
    
        String binary = Integer.toBinaryString(n);
        String flipped = "";

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                flipped += '1';
            } else {
                flipped += '0';
            }
        }

        return Integer.parseInt(flipped, 2);
    }
}