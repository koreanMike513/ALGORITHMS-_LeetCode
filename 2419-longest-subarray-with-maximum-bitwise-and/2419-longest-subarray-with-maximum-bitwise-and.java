class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 1, max = -1, n = nums.length;

        for (int num : nums) {
            if (num > max)
                max = num;
        }

        for (int i = 0; i < n; i++) {
            int start = i;

            while (i < n && nums[i] == max) { i++; }

            ans = Math.max(ans, i - start);
        }

        return ans;
    }
}