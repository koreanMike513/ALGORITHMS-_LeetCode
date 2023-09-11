class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0, right = nums.length - 1;
        long sum = 0;

        while (left <= right) {

            if (left == right) {
                sum += nums[left];
            }

            else {
                long div = 1;
                
                while (nums[right] / div > 0) {
                    div *= 10;
                }

                sum += nums[left] * div + nums[right];
            }

            left++; right--;
        }



        return sum;
    }
}