class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int k = 0; k < nums.length; k++) {
            int j = k;

            while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                k++;
            }

            if (k > j) { 
                nums[i] = nums[k];
                i++; 
            }

            nums[i] = nums[k];
            i++;
        }
        
        return i;
    }
}