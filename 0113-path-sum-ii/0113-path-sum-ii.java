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
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return list;

        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, targetSum, path);

        return list;
    }

    public void pathSumInner(TreeNode root, int sum, Stack<Integer> path) {
        if (root == null) return;
        
        path.push(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            list.add(new ArrayList<Integer>(path));
        }

        pathSumInner(root.left, sum - root.val, path);
        pathSumInner(root.right, sum - root.val, path);

        path.pop();
    }
}