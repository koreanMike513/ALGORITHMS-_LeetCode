class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int start = 0, i = 0, count = 1;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] <= nums[i++]) start = j;

            count = Math.max(count, j - start + 1);
        }

        return count;
    }
}