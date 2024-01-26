class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return findPaths(dp, maxMove, startRow, startColumn);
    }
    
    public int findPaths(int[][][] dp, int maxMove, int x, int y) {
        if (maxMove < 0) {
            return 0;
        }

        if (maxMove >= 0 && (x < 0 || x >= dp.length || y < 0 || y >= dp[0].length)) {
            return 1;
        }

        if (dp[x][y][maxMove] != -1) {
            return dp[x][y][maxMove];
        }

        int res = 0;

        res = (res + findPaths(dp, maxMove - 1, x - 1, y)) % 1000000007;
        res = (res + findPaths(dp, maxMove - 1, x + 1, y)) % 1000000007;
        res = (res + findPaths(dp, maxMove - 1, x, y - 1)) % 1000000007;
        res = (res + findPaths(dp, maxMove - 1, x, y + 1)) % 1000000007;

        return dp[x][y][maxMove] = res;
    }       
}
