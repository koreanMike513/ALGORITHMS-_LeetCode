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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<Double> ans = new ArrayList<>();

        qu.add(root);

        while (!qu.isEmpty()) {
            int level = qu.size();
            long sum = 0;

            for (int i = 0; i < level; i++) {
                TreeNode t = qu.poll();
                
                sum += t.val;

                if (t.left != null) {
                    qu.add(t.left);
                }

                if (t.right != null) {
                    qu.add(t.right);
                }
            }

            ans.add((double) sum / level);
        }

        return ans;
    }
}