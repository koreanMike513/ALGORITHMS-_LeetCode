class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, ans = 0;
        int[] dp = new int[n];
        
        for (int i = 2, prev = 0; i < n; i++) {
            dp[i] = (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) ? dp[i - 1] + 1 : 0;
            ans += dp[i];
        }
            
        return ans;
    }
}