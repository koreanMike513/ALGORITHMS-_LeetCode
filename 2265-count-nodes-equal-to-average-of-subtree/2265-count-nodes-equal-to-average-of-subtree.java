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
    public int averageOfSubtree(TreeNode root) {
        int count = 0;

        if (root == null) return 0;
        if (root.val == findSum(root) / findNodes(root)) count++;

        count += averageOfSubtree(root.left) + averageOfSubtree(root.right);

        return count;
    }

    public int findSum(TreeNode root) {
        int sum = 0;
        
        if (root == null) return 0;

        sum += root.val;
        sum += findSum(root.left);
        sum += findSum(root.right);
        
        return sum;
    }

    public int findNodes(TreeNode root) {
        int count = 0;
        
        if (root == null) return count;

        count++;
        count += findNodes(root.left) + findNodes(root.right);

        return count;
    }
}