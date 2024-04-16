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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;

            return n;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        int level = 1;

        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode c = qu.poll();

                if (level == depth - 1) {
                    TreeNode l = c.left;
                    TreeNode r = c.right;

                    c.left = new TreeNode(val);
                    c.left.left = l;

                    c.right = new TreeNode(val);
                    c.right.right = r;
                }

                else {
                    if (c.left != null)
                        qu.add(c.left);

                    if (c.right != null) 
                        qu.add(c.right);
                }
            }

            level++;
        }

        return root;
    }
}