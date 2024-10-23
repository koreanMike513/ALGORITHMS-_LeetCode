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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int depth = 0;

        qu.add(root);

        while (!qu.isEmpty()) {
            int size = qu.size(), sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();

                sum += node.val;

                if (node.left != null)
                    qu.add(node.left);
            
                if (node.right != null)
                    qu.add(node.right);
            }

            map.put(depth, sum);
            depth++;
        }

        map.put(1, 0);

        replaceValueInTree(root, map, 0, 0);

        return root;
    }

    private void replaceValueInTree(TreeNode node, Map<Integer, Integer> map, int depth, int replace) {
        if (node == null)
            return;

        node.val = replace;
        int t = 0;

        if (node.left != null && depth >= 1)
            t += node.left.val;

        if (node.right != null && depth >= 1)
            t += node.right.val;

        int r = map.getOrDefault(depth + 1, 0) - t;

        replaceValueInTree(node.left, map, depth + 1, r);
        replaceValueInTree(node.right, map, depth + 1, r);
    }
}