class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length, m = mat[0].length;
        int[][] sum = new int[n + 1][m + 1]; 
        int[][] ans = new int[n][m];

        for (int i = 1; i <= n; i++) {
            int prefixSum = 0;
            for (int j = 1; j <= m; j++) {
                prefixSum += mat[i - 1][j - 1];
                sum[i][j] = prefixSum + sum[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r1 = Math.max(i - K, 0), r2 = Math.min(i + K, n - 1);
                int c1 = Math.max(j - K, 0), c2 = Math.min(j + K, m - 1);
                r1++; c1++; r2++; c2++;

                ans[i][j] = sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1- 1][c1 - 1];
            }
        }

        return ans;
    }
}