class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int mod = 1_000_000_007;
        int goodStrings = 0;

        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0 && dp[i - zero] > 0)
                dp[i] += dp[i - zero];
            
            if (i - one >= 0 && dp[i - one] > 0)
                dp[i] += dp[i - one];

            dp[i] %= mod;
        }

        for (int i = low; i <= high; i++) {
            goodStrings = (goodStrings + dp[i]) % mod;
        }

        return goodStrings;
    }
}