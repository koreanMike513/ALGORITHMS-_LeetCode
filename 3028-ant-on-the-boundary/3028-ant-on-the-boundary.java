class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int n = nums.length, prefixSum = 0, ans = 0;
        
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (prefixSum == 0) {
                ans++;
            }
        }

        return ans;
    }
}