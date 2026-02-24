public class Main {

    // Definition for binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {

        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int currentValue) {
            if (node == null) {
                return 0;
            }

            // Form the binary number
            currentValue = currentValue * 2 + node.val;

            // If leaf node, return the formed number
            if (node.left == null && node.right == null) {
                return currentValue;
            }

            // Recur for left and right subtree
            return dfs(node.left, currentValue) +
                   dfs(node.right, currentValue);
        }
    }

    // PSVM
    public static void main(String[] args) {

        /*
                Example Tree:
                       1
                      / \
                     0   1
                    / \   \
                   0   1   1

                Root-to-leaf paths:
                100 -> 4
                101 -> 5
                111 -> 7

                Output = 4 + 5 + 7 = 16
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        Solution sol = new Solution();
        int result = sol.sumRootToLeaf(root);

        System.out.println("Sum of Root to Leaf Binary Numbers: " + result);
    }
}