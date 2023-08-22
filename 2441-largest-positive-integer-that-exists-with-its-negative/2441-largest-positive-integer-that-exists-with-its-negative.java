class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(-1 * nums[i])) {
                int num = (nums[i] < 0) ? -1 * nums[i] : nums[i];
                if (ans < num) ans = num;  
            }

            set.add(nums[i]);
        }

        return ans;
    }
}