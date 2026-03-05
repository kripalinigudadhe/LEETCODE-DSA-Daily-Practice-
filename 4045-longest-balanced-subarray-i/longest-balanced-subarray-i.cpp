class Solution {
public:
    int longestBalanced(vector<int>& nums) {
        int n = nums.size();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (n - i <= maxLength) break; // pruning

            unordered_set<int> even;
            unordered_set<int> odd;

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0)
                    even.insert(nums[j]);
                else
                    odd.insert(nums[j]);

                if (even.size() == odd.size()) {
                    maxLength = max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
};
