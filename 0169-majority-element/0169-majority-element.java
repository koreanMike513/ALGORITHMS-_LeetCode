class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 1, major = nums[0];

        for (int i = 1; i < nums.length; i++) {
            
            if (count == 0) {
                major = nums[i];
            }

            if (major == nums[i]) {
                count++;
            }

            else {
                count--;
            }
        }

        return major;
    }
}