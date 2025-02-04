class Solution {
    public int maxAscendingSum(int[] nums) {
        int prev = -1, sum = 0, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (prev < nums[i]) {
                sum += nums[i];
                prev = nums[i];
            }

            else {
                prev = nums[i];
                sum = nums[i];
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}