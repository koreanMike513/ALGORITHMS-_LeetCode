class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0, sum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];

            if (left == sum) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }
}