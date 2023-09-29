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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        List<Integer> list = DFS(root);
        TreeNode ans = new TreeNode(0);
        TreeNode fu = ans;

        for (int val : list) {
            fu.right = new TreeNode(val);
            fu = fu.right;
        }

        return ans.right;
    }

    public List<Integer> DFS (TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }

        System.out.println(root.val);

        list.addAll(DFS(root.left));
        list.add(root.val);
        list.addAll(DFS(root.right));

        return list;
    }
}