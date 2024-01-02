class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length; 
        int[][] dp = new int[n][n + 1];

        Arrays.sort(satisfaction);

        return maxSatisfaction(dp, satisfaction, 0, 1);
    }

    public int maxSatisfaction(int[][] dp, int[] satisfaction, int idx, int cof) {
        if (idx >= satisfaction.length) {
            return 0;
        }

        if (dp[idx][cof] != 0) {
            return dp[idx][cof];
        }

        int incl = (satisfaction[idx] * cof) + maxSatisfaction(dp, satisfaction, idx + 1, cof + 1);
        int not = maxSatisfaction(dp, satisfaction, idx + 1, cof);

        return dp[idx][cof] =  Math.max(incl, not);
    }
}