class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length, prev = -1, start = 0, ans = 1;

        for (int i = 0; i < n; i++) {
            if (prev < nums[i]) {
                ans = Math.max(ans, i - start + 1);
            }

            else {
                start = i;
            }

            prev = nums[i];
        }

        prev = 51;
        start = 0;

        for (int i = 0; i < n; i++) {
            if (prev > nums[i]) {
                ans = Math.max(ans, i - start + 1);
            }

            else {
                start = i;
            }

            prev = nums[i];
        }

        return ans;
    }
}