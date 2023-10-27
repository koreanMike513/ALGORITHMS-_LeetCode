class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, end = 0; 
        boolean[][] dp = new boolean[n][n];


        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                }
                
                else if (s.charAt(i) == s.charAt(j) && (gap < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }

                if (dp[i][j]) {
                    start = i; end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}