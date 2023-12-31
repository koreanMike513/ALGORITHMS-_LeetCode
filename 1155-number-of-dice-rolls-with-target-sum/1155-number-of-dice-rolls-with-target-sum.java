class Solution {
  private int mod = (int) Math.pow(10, 9) + 7;

  public int numRollsToTarget(int n, int k, int target) {
  	int[][] dp = new int[n + 1][target + 1];

    for (int i = 0; i <= n; i++) {
        Arrays.fill(dp[i], -1);
    }

    return numRollsToTarget(dp, n, k, target);
  }

  private int numRollsToTarget(int[][] dp, int n, int k, int target) {
    if (n == 0 && target == 0) 
        return 1;

    if (n == 0 || target < 0)
        return 0;

    if (dp[n][target] != -1)
        return dp[n][target];

    int count = 0;

    for (int i = 1; i <= k; i++) {
        target -= i;
        count = (count + numRollsToTarget(dp, n - 1, k, target) % mod) % mod;
        target += i;
    }

    return dp[n][target] = count;
  }

}