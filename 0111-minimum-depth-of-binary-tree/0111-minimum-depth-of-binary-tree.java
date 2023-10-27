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
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> qu = new LinkedList<>();
        int depth = 0;
        boolean isContinue = true;

        qu.add(root);

        while (!qu.isEmpty() && isContinue) {
            int level = qu.size();

            for (int i = 0; i < level; i++) {
                TreeNode t = qu.poll();

                if (t.left == null && t.right == null) {
                    isContinue = false;
                }

                if (t.left != null) {
                    qu.add(t.left);
                }

                if (t.right != null) {
                    qu.add(t.right);
                }
            }

            depth++;
        }

        return depth;
    }
}