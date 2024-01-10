class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int[] ans = new int[2];
        
        for (int i = 0; i < n - indexDifference; i++) {
            int j = i + indexDifference, min = ans[0], max = ans[1];
            
            if (nums[i] < nums[min]) {
                ans[0] = i;
                min = i;
            }

            if (nums[i] > nums[max]) {
                ans[1] = i;
                max = i;
            }

            if (Math.abs(nums[j] - nums[min]) >= valueDifference) {
                ans[1] = j;
                return ans;
            }

            if (Math.abs(nums[j] - nums[max]) >= valueDifference) {
                ans[0] = j;
                return ans;
            }
        }

        return new int[] {-1, -1};
    }
}