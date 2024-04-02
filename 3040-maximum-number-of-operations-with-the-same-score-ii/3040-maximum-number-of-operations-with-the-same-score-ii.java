class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        if (n < 3)
            return 1;

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return 1 + Math.max(
            maxOperations(dp, nums, 1, n - 2, nums[0] + nums[n - 1]),
            Math.max(
                maxOperations(dp, nums, 2, n - 1, nums[0] + nums[1]),
                maxOperations(dp, nums, 0, n - 3, nums[n - 1] + nums[n - 2])));
    }

    public int maxOperations(int[][] dp, int[] nums, int start, int end, int score) {
        if (start >= end) 
            return 0;
        
        if (dp[start][end] != -1) 
            return dp[start][end];

        int res = 0;

        if (nums[start] + nums[end] == score) 
            res = Math.max(res, 1 + maxOperations(dp, nums, start + 1, end - 1, nums[start] + nums[end]));

        if (nums[start] + nums[start + 1] == score) 
            res = Math.max(res, 1 + maxOperations(dp, nums, start + 2, end, nums[start] + nums[start + 1]));

        if (nums[end] + nums[end - 1] == score) 
            res = Math.max(res, 1 + maxOperations(dp, nums, start, end - 2, nums[end] + nums[end - 1]));    
        
        return dp[start][end] = res;
    }
}