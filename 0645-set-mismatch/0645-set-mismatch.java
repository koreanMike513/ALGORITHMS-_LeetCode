class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2], set = new int[n + 1];

        for (int i = 0; i < n; i++) {
            set[nums[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (set[i] > 1) {
                ans[0] = i;
            }

            else if (set[i] == 0) {
                ans[1] = i;
            }
        }

        return ans;
    }
}