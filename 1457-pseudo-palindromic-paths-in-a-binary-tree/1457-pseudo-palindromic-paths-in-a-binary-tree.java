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
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] nums = new int[10];
        return pseudoPalindromicPaths(root, nums);
    }

    public int pseudoPalindromicPaths(TreeNode root, int[] nums) {
        if (root == null) {
            return 0;
        }

        nums[root.val]++;

        if (root.left == null && root.right == null && isPalindrome(nums)) {
            nums[root.val]--;
            return 1;
        }

        int left = pseudoPalindromicPaths(root.left, nums);
        int right = pseudoPalindromicPaths(root.right, nums);

        nums[root.val]--;

        return left + right;
    }

    public boolean isPalindrome(int[] nums) {
        boolean hadOdd = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                continue;
            }

            else if (nums[i] % 2 == 1 && hadOdd) {
                return false;
            }

            else {
                hadOdd = true;
            }
        }

        return true;
    }
}