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
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        return (int) findBottomLeftValue(root, 0)[0];
    }

    public long[] findBottomLeftValue(TreeNode root, int level) {
        long fail = Integer.MIN_VALUE - 1;

        if (root == null) {
            return new long[] { fail, level };
        }

        if (root.left == null && root.right == null) {
            return new long[] { root.val, level };
        }

        long[] left = findBottomLeftValue(root.left, level + 1);
        long[] right = findBottomLeftValue(root.right, level + 1);

        if (left[0] == fail && right[0] != fail) {
            return right;
        }

        else if (left[0] != fail && right[0] == fail) {
            return left;
        }

        return (left[1] >= right[1]) ? left : right;
    }
}