class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, sa = Integer.MAX_VALUE;

        while (right < nums.length) {

            while (right < nums.length && sum < target) {
                sum += nums[right++];
            }

            while (sum >= target) {
                sa = Math.min(sa, right - left);
                sum -= nums[left++];
            }
        }

        return (sa == Integer.MAX_VALUE) ? 0 : sa;
    }


}