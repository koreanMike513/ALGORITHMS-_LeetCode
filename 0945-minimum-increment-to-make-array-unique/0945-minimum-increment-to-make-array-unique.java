class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        return minOperations(nums);
    }

    public int minOperations(int[] nums) {
        int count = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
            }
            
            else {
                max++;
                count += max - nums[i];
            }
        }

        return count;
    }
}