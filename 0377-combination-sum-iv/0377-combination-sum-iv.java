class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        Arrays.fill(dp, -1);
        dp[0] = 1;

        return combinationSum4(dp, nums, target);
    }

    public int combinationSum4(int[] dp, int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }

        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                c += combinationSum4(dp, nums, target - nums[i]);
            }
        }

        return dp[target] = c;
    }
}