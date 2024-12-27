class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, max = 0;
        int[] dp = new int[n];

        dp[0] = values[0];

        for (int i = 1; i < n; i++) {
            int current = values[i] - i;
            max = Math.max(max, dp[i - 1] + current);
            dp[i] = Math.max(dp[i - 1], values[i] + i);
        }

        return max;
    }
}