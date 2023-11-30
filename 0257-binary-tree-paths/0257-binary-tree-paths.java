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
        List<String> paths = new ArrayList<>();
        String path = "";

        DFS(root, path, paths);

        return paths;
    }

    public void DFS(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            path += root.val;
            paths.add(path);
        }

        path += root.val + "->";

        DFS(root.left, path, paths);
        DFS(root.right, path, paths);
    }
}