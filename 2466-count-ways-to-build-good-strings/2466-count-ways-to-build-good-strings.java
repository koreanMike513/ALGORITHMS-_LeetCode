class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
    
        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = low; i <= high; i++) {
            ans = (ans % 1000000007 + countGoodStrings(dp, low, high, zero, one, i) % 1000000007) % 1000000007;
        }

        return ans;
    }

    public int countGoodStrings(int[] dp, int low, int high, int zero, int one, int idx) {
        if (idx == 0) {
            return 1;
        }

        if (idx < 0) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        return dp[idx] = (
            countGoodStrings(dp, low, high, zero, one, idx - zero) + 
            countGoodStrings(dp, low, high, zero, one, idx - one)) % 1000000007;
    }
}