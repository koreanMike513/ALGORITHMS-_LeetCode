class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int ans = Integer.MAX_VALUE, n = grid.length, m = grid[0].length, l = moveCost[0].length;
        int[][] dp = new int[n][m];


        for (int j = 0; j < m; j++) {
            dp[0][j] = grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = 0; k < m; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j] + moveCost[grid[i - 1][k]][j]);
                }
            }
        }

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}