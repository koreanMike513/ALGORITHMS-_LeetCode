class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], -1);

        return cherryPickup(grid, dp, 0, 0, m - 1);
    }

    public int cherryPickup(int[][] grid, int[][][] dp, int r, int c1, int c2) {
        if (Math.min(c1, c2) < 0 || Math.max(c1, c2) >= dp[0].length || c1 == c2) {
            return 0;
        }

        int cherries = grid[r][c1] + grid[r][c2];

        if (r == dp.length - 1) {
            return cherries;
        }

        if (dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }

        int res = 0;

        for (int i : new int[] { -1, 0, 1 }) {
            for (int j : new int[] { -1, 0, 1 }) {
                res = Math.max(res, cherries + cherryPickup(grid, dp, r + 1, c1 + i, c2 + j));
            }
        }

        return dp[r][c1][c2] = res;
    }
}