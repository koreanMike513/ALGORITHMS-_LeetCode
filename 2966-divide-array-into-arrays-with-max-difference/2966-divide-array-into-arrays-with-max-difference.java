class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length, idx = 0;
        int[][] ans = new int[n / 3][3];
        Arrays.sort(nums);

        for (int i = 2; i < n; i += 3) {
            if (k < nums[i] - nums[i - 2]) {
                return new int[][] { };
            }
            ans[idx++] = new int[] { nums[i - 2], nums[i - 1], nums[i] };
        }

        return ans;
    }
}