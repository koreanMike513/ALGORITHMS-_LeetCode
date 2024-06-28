class Solution {
    int mod = 1_000_000_007;

    public int knightDialer(int n) {
        int m = 4, k = 3, ans = 0;
        
        int[][][] dp = new int[m][k][n + 1];
        int[][] directions = new int[][] { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

        for (int[][] d : dp) {
            for (int[] p : d) {
                Arrays.fill(p, -1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                if (!(i == 3 && (j == 0 || j == 2)))
                    ans = (((ans % mod) + (knightDialer(dp, directions, i, j, n - 1) % mod)) % mod);
            }
        }

        return ans % mod;
    }

    public int knightDialer(int[][][] dp, int[][] directions, int m, int k, int n) {
        if (n <= 0) 
            return 1;

        if (dp[m][k][n] != -1) 
            return dp[m][k][n];

        int res = 0;

        for (int[] direction : directions) {
            int i = m + direction[0];
            int j = k + direction[1];

            if ((i == 3 && (j == 0 || j == 2)) || i >= 4 || j >= 3 || i < 0 || j < 0)
                continue;

            res = (((res % mod) + (knightDialer(dp, directions, i, j, n - 1) % mod)) % mod);
        }

        return dp[m][k][n] = res % mod;
    }
}