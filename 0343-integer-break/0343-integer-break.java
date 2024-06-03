class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        return solve(n, dp);
    }
    public static int solve(int n,int[] dp){
        if (n == 1){
            return dp[n] = 1;
        }

        if (dp[n] != 0){
            return dp[n];
        }

        int max = 0;

        for (int i = 1; i <= n - 1; i++){
            int x = i * Math.max(n - i, solve(n - i, dp));
            max = Math.max(max, x);    
        }

        return dp[n] = max;
    }
}