class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long prefixSum = nums[0], ans = -1;   

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prefixSum) {
                ans = Math.max(ans, prefixSum + nums[i]);
            }

            prefixSum += nums[i];
        }

        return ans;
    }
}