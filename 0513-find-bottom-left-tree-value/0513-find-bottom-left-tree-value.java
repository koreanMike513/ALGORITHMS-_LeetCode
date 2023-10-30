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
        if (root.left == null && root.right == null) return root.val;
        
        Queue<TreeNode> qu = new LinkedList<>();
        int leftMost = -1;
        qu.add(root);

        while (!qu.isEmpty()) {
            int level = qu.size();

            for (int i = 0; i < level; i++) {
                TreeNode t = qu.poll();
                if (i == 0) {
                    leftMost = t.val;
                }

                if (t.left != null) {
                    qu.add(t.left);
                }

                if (t.right != null) {
                    qu.add(t.right);
                }
            }
        }

        return leftMost;
    }
}