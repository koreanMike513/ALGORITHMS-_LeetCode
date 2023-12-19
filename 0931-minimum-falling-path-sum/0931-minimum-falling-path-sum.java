class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int left = Math.max(0, j - 1);
                int right = Math.min(m - 1, j + 1);

                dp[i][j] = (matrix[i][j] + Math.min(
                    dp[i - 1][j], Math.min(
                        dp[i - 1][left], dp[i - 1][right])));
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}