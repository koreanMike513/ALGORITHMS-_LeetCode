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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        boolean isZigzag = false;

        if (root == null) return ans;

        qu.add(root);
        
        while (!qu.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int level = qu.size();

            for (int i = 0; i < level; i++) {
                TreeNode t = qu.poll();

                list.add(t.val);

                if (t.left != null) {
                    qu.add(t.left);
                }

                if (t.right != null) {
                    qu.add(t.right);
                }
            }

            if (isZigzag) Collections.reverse(list);

            ans.add(list);
            isZigzag = !isZigzag;
        }

        return ans;
     }

}