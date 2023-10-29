class Solution {
    public int countSubstrings(String s) {
        int ans = 0, n = s.length();
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                    ans++;
                }

                else if (s.charAt(i) == s.charAt(j) && (gap < 2 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    ans++;
                }
            }   
        }

        return ans;
    }
}