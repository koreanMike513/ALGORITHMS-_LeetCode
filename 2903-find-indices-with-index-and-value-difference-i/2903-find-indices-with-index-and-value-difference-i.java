class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        
        for (int i = 0; i + indexDifference < nums.length; i++) {
            int dif = i + indexDifference;

            while (dif < nums.length) {
                if (Math.abs(nums[i] - nums[dif]) >= valueDifference) {
                    return new int[] { i, dif };
                }

                dif++;
            }
        }

        return new int[] { -1, -1 };
    }
}