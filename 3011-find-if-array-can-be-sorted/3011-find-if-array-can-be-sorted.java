class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length, max1 = nums[0];

        for (int i = 1; i < n; i++) {
            while (i < n && Integer.bitCount(nums[i - 1]) == Integer.bitCount(nums[i])) {
                max1 = Math.max(max1, nums[i]);
                i++;
            }

            if (i == n)
                return true;

            int max2 = nums[i];
            int min2 = nums[i];

            while (i + 1 < n && Integer.bitCount(nums[i]) == Integer.bitCount(nums[i + 1])) {
                i++;
                max2 = Math.max(max2, nums[i]);
                min2 = Math.min(min2, nums[i]);
            }

            if (max1 > min2)
                return false;
            
            max1 = max2;
        }

        return true;
    }
}