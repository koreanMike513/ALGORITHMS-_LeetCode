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
    public String tree2str(TreeNode root) {
        String ans = tree2str(root, new StringBuilder());
        return ans.substring(1, ans.length() - 1);
    }

    public String tree2str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return "";
        }

        sb.append("(");
        sb.append(root.val);

        if (root.right != null && root.left == null) {
            sb.append("()");
        }
        
        tree2str(root.left, sb);
        
        if (root.right != null) {
            tree2str(root.right, sb);
        }

        sb.append(")");

        return sb.toString();
    }
}