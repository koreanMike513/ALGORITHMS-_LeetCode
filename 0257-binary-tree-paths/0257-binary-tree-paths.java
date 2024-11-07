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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return null;

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        binaryTreePaths(root, set, sb);

        return new ArrayList<>(set);
    }

    private void binaryTreePaths(TreeNode root, Set<String> set, StringBuilder sb) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            sb.append(root.val);
            set.add(sb.toString());
            return;
        }

        sb.append(root.val);
        sb.append("->");  
        binaryTreePaths(root.left, set, new StringBuilder(sb));
        binaryTreePaths(root.right, set, new StringBuilder(sb));
    }
}