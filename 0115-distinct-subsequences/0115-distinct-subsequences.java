class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return numDistinct(dp, s, t, 0, 0);
    }

    public int numDistinct(int[][] dp, String s, String t, int idxS, int idxT) {
        if (idxT >= t.length()) {
            return 1;
        }

        if (idxS >= s.length()) {
            return 0;
        } 

        if (dp[idxS][idxT] != -1) {
            return dp[idxS][idxT];
        }

        int res = 0;

        if (s.charAt(idxS) == t.charAt(idxT)) {
            res = numDistinct(dp, s, t, idxS + 1, idxT) + numDistinct(dp, s, t, idxS + 1, idxT + 1);
        }

        else {
            res = numDistinct(dp, s, t, idxS + 1, idxT);
        }

        return dp[idxS][idxT] = res;
    }
}