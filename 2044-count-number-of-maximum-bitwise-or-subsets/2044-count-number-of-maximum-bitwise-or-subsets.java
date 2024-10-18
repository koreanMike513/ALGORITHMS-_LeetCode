class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int or = 0;

        for (int num : nums) {
            or |= num;
        }

        return helper(nums, or, 0, 0);
    }

    private int helper(int[] nums, int or, int idx, int current) {
        if (idx >= nums.length) {
            return 0;
        }

        int res = current | nums[idx];
        int c = (res == or) ? 1 : 0;

        return c + helper(nums, or, idx + 1, current) + helper(nums, or, idx + 1, current |= nums[idx]);
    }
}