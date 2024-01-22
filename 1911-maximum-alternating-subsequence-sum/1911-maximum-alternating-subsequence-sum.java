class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxAlternatingSum(dp, nums, 0, 0);
    }

    private long maxAlternatingSum(long[][] dp, int[] nums, int idx, int state) {
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx][state] != -1) {
            return dp[idx][state];
        }

        long op1 = maxAlternatingSum(dp, nums, idx + 1, state);
        long op2 = (state == 0 ? 1 : -1) * nums[idx] + maxAlternatingSum(dp, nums, idx + 1, state^1);

        return dp[idx][state] = Math.max(op1, op2);
    }
}