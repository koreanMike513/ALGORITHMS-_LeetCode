class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        int[] opt = new int[n];
        
        sum[0] = nums[0];
        opt[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
            opt[i] = Math.max(opt[i - 1], sum[i]);
        }

        return opt[n - 1];
    }
}