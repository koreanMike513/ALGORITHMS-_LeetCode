class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int o = 0, m = (nums.length / 2);

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                ans[i] = nums[o++];
            }
            else {
                ans[i] = nums[m++];
            }
        }

        return ans;
    }
}