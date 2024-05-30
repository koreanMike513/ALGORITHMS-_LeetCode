class Solution {
    public int longestNiceSubarray(int[] nums) {
        int current = 0, n = nums.length, ans = 1, start = 0;

        for (int i = 0; i < n; i++) {
            while (start < i && (current & nums[i]) != 0) {
                current = current ^ nums[start];
                start++;
            }

            current = current | nums[i];
            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}