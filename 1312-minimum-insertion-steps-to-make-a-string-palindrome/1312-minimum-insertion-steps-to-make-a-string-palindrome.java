class Solution {
    public int minInsertions(String s) {
        int n = s.length(), max = 0;
        String rs = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = (s.charAt(i) == rs.charAt(j)) 
                ? dp[i + 1][j + 1] + 1
                : Math.max(dp[i + 1][j], dp[i][j + 1]);

                max = Math.max(max, dp[i][j]);
            }
        }

        return s.length() - max;
    }
}