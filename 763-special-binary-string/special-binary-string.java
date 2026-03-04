import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {

        List<String> specialStrings = new ArrayList<>();

        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            // Found a balanced special substring
            if (count == 0) {

                // Recursively solve inside substring
                String inner = makeLargestSpecial(s.substring(start + 1, i));

                specialStrings.add("1" + inner + "0");
                start = i + 1;
            }
        }

        // Sort in descending order for lexicographically largest
        Collections.sort(specialStrings, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String str : specialStrings) {
            result.append(str);
        }

        return result.toString();
    }
}