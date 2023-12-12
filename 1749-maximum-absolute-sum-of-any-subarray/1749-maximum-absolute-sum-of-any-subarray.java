class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length, sum1 = 0, sum2 = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            sum1 = Math.max(nums[i], sum1 + nums[i]);
            sum2 = Math.min(nums[i], sum2 + nums[i]);

            ans = Math.max(ans, Math.max(sum1, -sum2));
        }

        return ans;
    }
}