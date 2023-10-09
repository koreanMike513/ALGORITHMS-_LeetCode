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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = findLeaf(root1);
        List<Integer> list2 = findLeaf(root2);

        int n1 = list1.size(), n2 = list2.size();

        if (n1 != n2) return false;

        return list1.equals(list2);
    }

    public List<Integer> findLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);

            return list;
        }

        list.addAll(findLeaf(root.left)); 
        list.addAll(findLeaf(root.right));

        return list;
    }
}