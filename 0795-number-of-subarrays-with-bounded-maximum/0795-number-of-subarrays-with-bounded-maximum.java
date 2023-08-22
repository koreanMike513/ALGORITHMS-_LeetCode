class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;

        for (int l = 0; l < nums.length; l++) {
            int r = l;
            
            if (nums[r] >= left && nums[r] <= right) {
                while (r < nums.length && nums[r] <= right) r++;
                count += r - l;
            }

            else if (nums[r] <= left) {
                int temp = -1, f = 0;
                
                while (r < nums.length && nums[r] <= right) {
                    if (nums[r] >= left && nums[r] <= right) {
                        if (f == 0) f = r;
                        temp = nums[r]; 
                    }
                    r++;
                }
                if (temp != -1) count += r - l - (f - l);
            }
        }

        return count;
    }
}