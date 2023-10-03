class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map[nums[i]] > 0) {
                ans += map[nums[i]];
            }

            map[nums[i]]++;
        }

        return ans;
    }
}