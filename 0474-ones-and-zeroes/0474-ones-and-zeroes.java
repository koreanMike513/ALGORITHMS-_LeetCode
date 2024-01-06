class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 0; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return findMaxForm(dp, strs, m, n, strs.length);
    }

    public int findMaxForm(int[][][] dp, String[] strs, int m, int n, int idx) {
        if (m < 0 || n < 0) {
            return -1;
        }

        if (idx == 0) {
            return 0;
        }

        if (dp[idx][m][n] != -1) {
            return dp[idx][m][n];
        }

        int zeros = countZeros(strs[idx - 1]);
        int ones = strs[idx - 1].length() - zeros;

        return dp[idx][m][n] = Math.max(
            findMaxForm(dp, strs, m - zeros, n - ones, idx - 1) + 1, 
            findMaxForm(dp, strs, m, n, idx - 1));
    }

    public int countZeros(String str) {
        int zero = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zero++;
            }
        }
        
        return zero;
    }
}