/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        int depth = 0;
        dfs(root.left, root.right, depth);

        return root;
    }

    private void dfs (TreeNode left, TreeNode right, int depth) {
        if (left == null && right == null) 
            return;

        if (depth % 2 == 0) {
            int t = left.val;
            left.val = right.val;
            right.val = t;
        }

        depth++;
        dfs(left.left, right.right, depth);
        depth--;

        depth++;
        dfs(left.right, right.left, depth);
        depth--;
    }
}