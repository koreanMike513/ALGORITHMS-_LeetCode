class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length, prefix = 0, postfix = 0;

        for (int i = 0; i < nums.length; i++) {
            postfix += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            postfix -= nums[i];

            if (prefix == postfix) {
                return i;
            }
            
            prefix += nums[i];
        }

        return -1;
    }
}