class Solution {
    public int minPairSum(int[] nums) {
        int i = 0, j = nums.length - 1, max = 0;

        Arrays.sort(nums);

        while (i < j) {
            int sum = nums[i++] + nums[j--];
            if (sum > max) max = sum;
        }

        return max;
    }
}