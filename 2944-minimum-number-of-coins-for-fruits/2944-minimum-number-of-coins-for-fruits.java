class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minimumCoins(prices, dp, 0, 0);
    }

    public int minimumCoins(int[] prices, int[][] dp, int idx, int free) {
        if (idx >= prices.length) {
            return 0;
        }

        if (dp[idx][free] != -1) {
            return dp[idx][free];
        }

        int take = prices[idx] + minimumCoins(prices, dp, idx + 1, idx + 1);
        int notTake = (free > 0) ? minimumCoins(prices, dp, idx + 1, free - 1) : Integer.MAX_VALUE;

        return dp[idx][free] = Math.min(take, notTake);
    }
}