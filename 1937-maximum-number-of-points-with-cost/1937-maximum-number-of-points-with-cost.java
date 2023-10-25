class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m][n];

        
        for (int j = 0; j < n; j++) {
            dp[0][j] = points[0][j];
        }
        

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long max = 0;
                
                for (int k = 0; k < n; k++) {
                    max = Math.max(max, dp[i - 1][k] - Math.abs(j - k));
                }

                dp[i][j] = points[i][j] + max;
            }
        }

        long ans = 0;
    
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[m - 1][j]);
        }

        return ans;
    }
}