class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;   
        if (n <= 4) return 0;
        Arrays.sort(nums);
        
        int minv = Integer.MAX_VALUE;
     
        // Case 1 : converting last three values
        minv = Math.min(minv, nums[n - 4] - nums[0]);
        
        // Case 2: Converting first three values
        minv = Math.min(minv, nums[n - 1] - nums[3]);
        
        // Case 3: Converting 2 left vaules and 1 right value
        minv = Math.min(minv, nums[n - 3] - nums[1]);
        
        // Case 4 : Converting 1 left value and 2 right values
        minv = Math.min(minv, nums[n - 2] - nums[2]);
        
        return minv;
    }
}