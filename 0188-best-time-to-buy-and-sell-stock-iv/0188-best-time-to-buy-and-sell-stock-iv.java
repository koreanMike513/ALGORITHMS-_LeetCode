class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxProfit(dp, prices, k, 0, 0, 0);
    }

    public int maxProfit(int[][][] dp, int[] prices, int k, int c, int own, int idx) {
        if (idx >= prices.length || c > k) {
            return 0;
        }

        if (dp[idx][own][c] != -1) {
            return dp[idx][own][c];
        }

        if (own == 0) {
            int a = -prices[idx] + maxProfit(dp, prices, k, c + 1, 1, idx + 1);
            int b = maxProfit(dp, prices, k, c, 0, idx + 1);

            dp[idx][own][c] = Math.max(a, b);
        }

        else {
            int a = prices[idx] + maxProfit(dp, prices, k, c, 0, idx + 1);
            int b = maxProfit(dp, prices, k, c, 1, idx + 1);

            dp[idx][own][c] = Math.max(a, b);
        }

        return dp[idx][own][c];
    }
}