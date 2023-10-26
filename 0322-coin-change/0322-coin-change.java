class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);

        for (int i = 0; i < coins.length; i++) {
            if (amount + 1 > coins[i]) {
                dp[coins[i]] = 1;
            }
        }

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] > 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return (dp[amount] != 10001) ? dp[amount] : -1;
    }
}