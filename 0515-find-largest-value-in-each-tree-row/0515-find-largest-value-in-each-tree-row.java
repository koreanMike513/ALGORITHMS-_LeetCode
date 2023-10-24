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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        
        if (root == null) {
            return ans;
        }

        qu.add(root);

        while (!qu.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int level = qu.size();

            for (int i = 0; i < level; i++) {
                TreeNode node = qu.poll();
                
                if (max < node.val) {
                    max = node.val;
                }

                if (node.left != null) {
                    qu.add(node.left);
                }

                if (node.right != null) {
                    qu.add(node.right);
                }
            }

            ans.add(max);
        }

        return ans;
    }
}