class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        int[][][] dp = new int[n][2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxProfit(dp, prices, 0, 0, 0);
    }

    public int maxProfit(int[][][] dp, int[] prices, int idx, int own, int limit) {
        if (idx >= prices.length || limit >= 2) {
            return 0;
        }

        if (dp[idx][own][limit] != -1) {
            return dp[idx][own][limit];
        }

        if (own == 0) {
            int a = -prices[idx] + maxProfit(dp, prices, idx + 1, 1, limit);
            int b = maxProfit(dp, prices, idx + 1, 0, limit);

            return dp[idx][own][limit] = Math.max(a, b);
        }

        else {
            int a = prices[idx] + maxProfit(dp, prices, idx + 1, 0, limit + 1);
            int b = maxProfit(dp, prices, idx + 1, 1, limit);
            
            return dp[idx][own][limit] = Math.max(a, b);
        }
    }
}