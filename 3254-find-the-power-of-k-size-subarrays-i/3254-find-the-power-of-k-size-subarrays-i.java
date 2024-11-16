class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            if (isConsecutive(nums, i, i + k))
                ans[i] = nums[i + k - 1];

            else
                ans[i] = -1;
        }

        return ans;
    }

    private boolean isConsecutive(int[] nums, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (nums[i - 1] + 1 != nums[i])
                return false;
        }

        return true;
    }
}