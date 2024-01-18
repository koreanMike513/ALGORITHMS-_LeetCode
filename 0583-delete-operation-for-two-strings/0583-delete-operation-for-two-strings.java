class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length(), max = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = (word1.charAt(i) == word2.charAt(j)) 
                ? dp[i + 1][j + 1] + 1 
                : Math.max(dp[i][j + 1], dp[i + 1][j]);

                max = Math.max(max, dp[i][j]);
            }
        }

        return (n - max) + (m - max);
    }
}