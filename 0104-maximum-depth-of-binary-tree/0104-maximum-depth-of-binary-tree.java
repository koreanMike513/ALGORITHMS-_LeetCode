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
    public int maxDepth(TreeNode root) {
        return BFS(root, 0);
    }

    public int BFS (TreeNode root, int depth) {
        if (root == null) return depth;

        return Math.max(BFS(root.left, depth + 1), BFS(root.right, depth + 1));
    }
}