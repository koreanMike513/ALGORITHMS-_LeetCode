class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        if (n == 1)
            return nums[0];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[1], dp1[0]);

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        dp2[1] = nums[1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}