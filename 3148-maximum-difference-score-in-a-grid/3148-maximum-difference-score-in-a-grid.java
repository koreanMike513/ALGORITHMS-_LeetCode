class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size(), m = grid.get(0).size(), ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1)
                    continue;

                int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE, d = Integer.MIN_VALUE;
                
                if (i + 1 < n) {
                    a = (grid.get(i + 1).get(j) - grid.get(i).get(j)) + dp[i + 1][j];
                    b = grid.get(i + 1).get(j) - grid.get(i).get(j);
                }

                if (j + 1 < m) {
                    c = (grid.get(i).get(j + 1) - grid.get(i).get(j)) + dp[i][j + 1];
                    d = grid.get(i).get(j + 1) - grid.get(i).get(j);
                }

                dp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}