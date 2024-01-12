class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[j] - nums[i];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        
        return ans;
    }
}