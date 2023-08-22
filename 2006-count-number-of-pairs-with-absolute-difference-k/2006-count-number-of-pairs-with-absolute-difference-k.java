class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] map = new int[101];
        int ans = 0;


        for (int num: nums) { 
            map[num]++; 
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + k < 101 && map[nums[i] + k] > 0) {
                ans += map[nums[i] + k];
            }
        }

        return ans;
    }
}