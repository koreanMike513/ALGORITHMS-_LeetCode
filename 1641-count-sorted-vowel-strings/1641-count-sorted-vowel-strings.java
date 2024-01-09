class Solution {
    public int countVowelStrings(int n) {
        String[] s = new String[] { "a", "e", "i", "o", "u" };
        int[][] dp = new int[5][n + 1];

        for (int i = 0; i < 5; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countVowelStrings(dp, s, n, 0);
    }

    public int countVowelStrings(int[][] dp, String[] s, int n, int idx) {
        if (n == 0) {
            return 1;
        }

        if (idx >= s.length) {
            return 0;
        }

        if (dp[idx][n] != -1) {
            return dp[idx][n];
        }

        int pick = countVowelStrings(dp, s, n - 1, idx);
        int notPick = countVowelStrings(dp, s, n, idx + 1);

        return dp[idx][n] = pick + notPick;
    }
}