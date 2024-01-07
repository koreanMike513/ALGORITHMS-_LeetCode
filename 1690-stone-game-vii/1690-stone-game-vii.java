class Solution {
    public int stoneGameVII(int[] stones) {
        int sum = 0, n = stones.length;
        int[][][] dp = new int[2][n][n]; 

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int stone : stones) { 
            sum += stone; 
        }

        return stoneGameVII(dp, stones, 0, n - 1, 0, sum);
    }

    public int stoneGameVII(int[][][] dp, int[] stones, int start, int end, int p, int sum) {
        if (start > end) {
            return 0;
        }

        if (dp[p][start][end] != -1) {
            return dp[p][start][end];
        }

        int res = (p == 0) ? 0 : 1000001;

        if (p == 0) {
            res = Math.max(res, 
                Math.max(
                    sum - stones[start] + stoneGameVII(dp, stones, start + 1, end, 1, sum - stones[start]), 
                    sum - stones[end] + stoneGameVII(dp, stones, start, end -1, 1, sum - stones[end])));
        }

        else {
            res = Math.min(res, 
                Math.min(
                    -sum + stones[start] + stoneGameVII(dp, stones, start + 1, end, 0, sum - stones[start]), 
                    -sum + stones[end] + stoneGameVII(dp, stones, start, end -1, 0, sum - stones[end])));
        }

        return dp[p][start][end] = res;
    }
}