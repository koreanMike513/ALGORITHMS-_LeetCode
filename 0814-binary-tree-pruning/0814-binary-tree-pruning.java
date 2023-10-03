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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.val == 1 || (hasOne(root.left) || hasOne(root.right))) {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        }

        else {
            return null;
        }

        return root;
    }

    public boolean hasOne(TreeNode root) {
        if (root == null) return false;
        if (root.val == 1) return true;

        return hasOne(root.left) || hasOne(root.right);
    }
}