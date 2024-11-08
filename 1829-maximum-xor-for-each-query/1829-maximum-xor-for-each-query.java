class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0, n = nums.length, max = (int) Math.pow(2, maximumBit) - 1;
        int[] ans = new int[n];

        for (int num : nums) {
            xor ^= num;
        }

        for (int i = 0; i < n; i++) {
            ans[i] = xor ^ max;
            xor ^= nums[n - i - 1];
        }

        return ans;
    }
}