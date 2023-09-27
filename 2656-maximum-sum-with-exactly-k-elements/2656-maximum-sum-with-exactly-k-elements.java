class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, base = nums[nums.length - 1];

        for (int i = 0; i < k; i++) {
            ans += base;
            base++;
        }

        return ans;
    }
}