class Solution {
    public int longestPalindromeSubseq(String s) {
        int ans = 1, n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        String rs = new StringBuilder(s).reverse().toString();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = (s.charAt(i) == rs.charAt(j)) 
                ? dp[i + 1][j + 1] + 1
                : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[0][j]);
        }

        return ans;
    }
}