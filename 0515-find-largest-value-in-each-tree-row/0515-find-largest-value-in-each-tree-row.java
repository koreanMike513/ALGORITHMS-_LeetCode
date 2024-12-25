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
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if (root != null)
            qu.add(root);

        while(!qu.isEmpty()) {
            int size = qu.size();
            int v = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();

                if (node.val > v)
                    v = node.val;
                
                if (node.left != null)
                    qu.add(node.left);
                
                if (node.right != null)
                    qu.add(node.right);
            }

            list.add(v);
        }

        return list;
    }
}