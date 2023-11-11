class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[n - 1] = cost[n - 1];
        dp1[n - 2] = cost[n - 2];

        dp2[n - 1] = cost[n - 1];
        dp2[n - 2] = cost[n - 2];

        for (int i = n - 3; i >= 0; i--) {
            dp1[i] = cost[i] + Math.min(dp1[i + 1], dp1[i + 2]);
        }

        for (int i = n - 3; i >= 1; i--) {
            dp2[i] = cost[i] + Math.min(dp2[i + 1], dp2[i + 2]);
        }

        return Math.min(dp1[0], dp2[1]);
    }
}