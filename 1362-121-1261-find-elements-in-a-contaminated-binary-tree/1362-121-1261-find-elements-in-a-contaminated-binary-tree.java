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
class FindElements {
    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) {
            left.val = root.val * 2 + 1;
            recover(left);
        }

        if (right != null) {
            right.val = root.val * 2 + 2;
            recover(right);
        }

        set.add(root.val);
    }

    private void recover(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;

        set.add(node.val);

        if (left != null) {
            left.val = node.val * 2 + 1;
            recover(left);
        }

        if (right != null) {
            right.val = node.val * 2 + 2;
            recover(right);
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */