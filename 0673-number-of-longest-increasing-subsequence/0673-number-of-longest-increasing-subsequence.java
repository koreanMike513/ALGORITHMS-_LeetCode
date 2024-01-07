class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 1, ans = 0;
        int[] dp = new int[n];
        int[] freq = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(freq, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        freq[i] = freq[j];
                    }

                    else if (dp[j] + 1 == dp[i]) {
                        freq[i] += freq[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] == max) 
                ans += freq[i];
        }

        return ans;
    }
}