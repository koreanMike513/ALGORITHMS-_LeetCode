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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int freq = 0;

        int sum = findFrequentTreeSum(map, root);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        for (Integer sub : map.keySet()) {
            freq = Math.max(freq, map.get(sub));
        }

        for (Integer sub : map.keySet()) {
            if (map.get(sub) == freq) {
                set.add(sub);
            }
        }

        int[] ans = new int[set.size()];
        int idx = 0;

        for (Integer num : set) {
            ans[idx++] = num;
        }

        return ans;
    }

    public int findFrequentTreeSum(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        int left = findFrequentTreeSum(map, root.left); 
        int right = findFrequentTreeSum(map, root.right); 

        if (left != Integer.MAX_VALUE) {
            map.put(left, map.getOrDefault(left, 0) + 1);
        }

        else {
            left = 0;
        }

        if (right != Integer.MAX_VALUE) {
            map.put(right, map.getOrDefault(right, 0) + 1);
        }

        else {
            right = 0;
        }

        return left + right + root.val;
    }
}