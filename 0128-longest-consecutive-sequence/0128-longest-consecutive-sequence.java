class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int ans = 1;

        for (Integer num: nums) set.add(num);

        for (int i = 0; i < nums.length; i++) {
            
            if (set.remove(nums[i])) {
                int len = 1;
                int val = nums[i];

                while (set.remove(val - 1)) val--;

                len += nums[i] - val;

                val = nums[i];

                while (set.remove(val + 1)) val++;

                len += val - nums[i];

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
} 