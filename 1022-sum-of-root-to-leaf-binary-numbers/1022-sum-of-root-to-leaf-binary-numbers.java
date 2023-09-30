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
    private List<Integer> list = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        
        findPath(root, st);

        return list.stream()
            .reduce(0, (a, b) -> a + b);
    }

    public void findPath(TreeNode root, Stack<Integer> st) {
        if (root == null) {
            return;
        }

        st.push(root.val);

        if (root.left == null && root.right == null) {
            List<Integer> t = new ArrayList<Integer>(st);
            int value = 0, base = 0;

            while (t.size() > 0) {
                value += Math.pow(2, base++) * t.remove(t.size() - 1);
            }

            list.add(value);
            st.pop();

            return;
        }

        findPath(root.left, st);
        findPath(root.right, st);

        st.pop();
    }
}