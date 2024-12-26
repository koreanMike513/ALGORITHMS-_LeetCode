class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;

        for (int num : nums) {
            sum += num;
        }

        int[][] dp = new int[n][2 * sum + 1];
        dp[0][ nums[0] + sum] = 1;
        dp[0][-nums[0] + sum] += 1;

        for (int i = 1; i < n; i++) {
            for (int s = -sum; s <= sum; s++) {
                if (dp[i - 1][s + sum] > 0) {
                    dp[i][s + nums[i] + sum] += dp[i - 1][s + sum];
                    dp[i][s - nums[i] + sum] += dp[i - 1][s + sum];
                }
            }
        }

        return Math.abs(target) > sum
            ? 0
            : dp[n - 1][target + sum];
    }
}