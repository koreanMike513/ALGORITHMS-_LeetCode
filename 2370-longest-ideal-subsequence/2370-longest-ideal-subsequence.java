class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][130];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return longestIdealString(s, 0, k, dp, '#');
    }

    private int longestIdealString(String s, int idx, int k, int[][] dp, char ch) {
        if (idx >= s.length()) {
            return 0;
        }

        if (dp[idx][ch] != -1) {
            return dp[idx][ch];
        }

        int take = 0, nontake = 0;

        if (Math.abs(ch - s.charAt(idx)) <= k || ch == '#') 
            take = 1 + longestIdealString(s, idx + 1, k, dp, s.charAt(idx));
        
        nontake = longestIdealString(s, idx + 1, k, dp, ch);

        return dp[idx][ch] = Math.max(take, nontake);
    }

}