class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, ans = nums[0];

        int max = nums[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max + nums[i], nums[i]);
            ans = Math.max(ans, max);
        }

        return ans;
    }
}