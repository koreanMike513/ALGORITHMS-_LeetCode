class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length, ans = -1;
        int[] sum1 = new int[n];
        int[] sum2 = new int[n];

        sum1[0] = nums[0];
        sum2[0] = nums[0];

        ans = Math.max(ans, Math.max(sum1[0], -sum2[0]));

        for (int i = 1; i < n; i++) {
            sum1[i] = Math.max(sum1[i - 1] + nums[i], nums[i]);
            sum2[i] = Math.min(sum2[i - 1] + nums[i], nums[i]);

            ans = Math.max(ans, Math.max(sum1[i], -sum2[i]));
        }

        return ans;
    }
}