/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, Integer> depths = new HashMap<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();
        int depth = 1;

        qu.add(root);
        parents.put(root, null);

        while(!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();

                if (node.left != null) {
                    qu.add(node.left);
                    parents.put(node.left, node);
                }
                
                if (node.right != null) {
                    qu.add(node.right);
                    parents.put(node.right, node);
                }

                depths.put(node, depth);
            }

            depth++;
        }

        return findLowestCommonAncestor(p, q, depths, parents);
    }

    private TreeNode findLowestCommonAncestor(TreeNode p, TreeNode q, Map<TreeNode, Integer> depths, Map<TreeNode, TreeNode> parents) {
        while (depths.get(p) < depths.get(q)) {
            q = parents.get(q);
        }

        while (depths.get(p) > depths.get(q)) {
            p = parents.get(p);
        }

        while (p != q) {
            p = parents.get(p);
            q = parents.get(q);
        }

        return q;
    }
}