class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length, i = 0;
        int[][] dp = new int[m][n];

        while (i < m) {
            if (obstacleGrid[i][0] == 0) dp[i++][0] = 1;
            else break;
        }

        i = 0;

        while (i < n) {
            if (obstacleGrid[0][i] == 0) dp[0][i++] = 1;
            else break;
        }

        for (int k = 1; k < m; k++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[k][j] != 1) {
                    dp[k][j] = dp[k - 1][j] + dp[k][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}