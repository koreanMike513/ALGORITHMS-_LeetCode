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
    public int maxLevelSum(TreeNode root) {
        int sum = -100001, level = 1, maxLevel = 0;
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);

        while (!qu.isEmpty()) {
            int size = qu.size();
            int tempSum = 0;
            
            for (int i = 0; i < size; i++) {
                TreeNode t = qu.poll();
                tempSum += t.val;

                if (t.left != null) {
                    qu.add(t.left);
                }

                if (t.right != null) {
                    qu.add(t.right);
                }
            }

            if (sum < tempSum) {
                sum = tempSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }
}