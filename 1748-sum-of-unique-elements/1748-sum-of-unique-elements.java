class Solution {
    public int sumOfUnique(int[] nums) {
        int ans = 0;
        int[] map = new int[101];

        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                ans += i;
            }
        }

        return ans;
    }
}