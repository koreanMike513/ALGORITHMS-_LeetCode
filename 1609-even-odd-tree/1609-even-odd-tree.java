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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        int level = 1; 
        qu.add(root);

        while (!qu.isEmpty()) {
            int size = qu.size();
            int prev = (level % 2 == 1) ? 0 : (int) Math.pow(10, 6) + 1;
            for (int i = 0; i < size; i++) {
                TreeNode current = qu.poll();
                if ((level % 2 == 1 && (current.val % 2 != 1 || current.val <= prev)) || 
                (level % 2 == 0 && (current.val % 2 != 0 || prev <= current.val))) {
                    return false;
                } 

                if (current.left != null) {
                    qu.add(current.left);
                }

                if (current.right != null) {
                    qu.add(current.right);
                }

                prev = current.val;
            }

            level++;
        }

        return true;
    }
}