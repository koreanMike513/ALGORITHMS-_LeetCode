class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < target) {
                    j++;
                }

                else if (target < sum) {
                    k--;
                }

                else {
                    closest = sum;
                    break;
                }

                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
            }
        }

        return closest;
    }
}
