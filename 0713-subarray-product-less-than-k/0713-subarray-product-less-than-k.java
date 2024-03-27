class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        
        int current = 1, count = 0, n = nums.length, left = 0, right = left;

        while (right < n) {
            current *= nums[right];

            while (current >= k) {
                current /= nums[left++];
            }

            count += right - left + 1;
            right++;
        }
        
        return count;
    }   
}