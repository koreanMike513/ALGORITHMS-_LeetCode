class Solution {
    public int maxSum(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        int[][] prefixSum = new int[n + 2][m + 2];

        for (int i = 0; i < n; i++) {
            int prefix = 0;
            for (int j = 0; j < m; j++) {
                prefix += grid[i][j];
                prefixSum[i + 1][j + 1] = prefix;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 2; j < m; j++) {
                ans = Math.max(ans, 
                prefixSum[i - 1][j + 1] - prefixSum[i - 1][j - 2] + 
                prefixSum[i + 1][j + 1] - prefixSum[i + 1][j - 2] + 
                prefixSum[i][j] - prefixSum[i][j - 1]);
            }
        }

        return ans;
    }
}