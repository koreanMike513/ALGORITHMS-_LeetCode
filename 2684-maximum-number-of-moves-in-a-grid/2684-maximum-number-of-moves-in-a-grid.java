class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;

        
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i - 1 >= 0 && (dp[i - 1][j - 1] > 0 || j == 1) && grid[i - 1][j - 1] < grid[i][j])
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j - 1]);

                if ((dp[i][j - 1] > 0 || j == 1) && grid[i][j - 1] < grid[i][j])
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j - 1]);
                                      
                if (i + 1 < n && (dp[i + 1][j - 1] > 0 || j == 1) && grid[i + 1][j - 1] < grid[i][j])
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j - 1]);
                
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}