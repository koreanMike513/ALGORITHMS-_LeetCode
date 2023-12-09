class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, length = 0, count = k;

        for (int right = left; right < nums.length; right++) {
            if (nums[right] == 0) {
                count--;
            }

            while (count < 0) {
                if(nums[left++] == 0) {
                    count++;
                }
            }

            length = Math.max(length, right - left + 1);
        }

        return length;
    }
}