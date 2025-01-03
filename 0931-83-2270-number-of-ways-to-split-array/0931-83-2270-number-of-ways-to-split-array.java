class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0, t = 0, valid = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            sum -= nums[i];
            t += nums[i];

            if (t >= sum)
                valid++;
        }

        return (int) valid;
    }
}