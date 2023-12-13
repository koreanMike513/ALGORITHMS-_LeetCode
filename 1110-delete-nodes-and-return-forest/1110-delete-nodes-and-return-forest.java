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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int value : to_delete) { set.add(value); }

        root = delNodes(list, root, null, set);
        
        if (root != null) list.add(root);

        return list;
    }

    public TreeNode delNodes(List<TreeNode> list, TreeNode root, TreeNode parents, Set<Integer> set) {
        if (root == null) {
            return null;
        }

        root.left = delNodes(list, root.left, root, set);
        root.right = delNodes(list, root.right, root, set);

        if (set.contains(root.val)) {
            if (root.left != null) {
                list.add(root.left);
            }

            if (root.right != null) {
                list.add(root.right);
            }

            root = null;
        }

        return root;
    }
}