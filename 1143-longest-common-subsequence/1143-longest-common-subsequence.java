class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length(), ans = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = (text1.charAt(i) == text2.charAt(j)) 
                ? dp[i + 1][j + 1] + 1 
                : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, dp[0][j]);
        }

        return ans;
    }
}