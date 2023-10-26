class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, max = 0;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) { 
            dp[i] = 1; 
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < len; i++) { 
            max = Math.max(max, dp[i]); 
        }

        return max;
    }
}