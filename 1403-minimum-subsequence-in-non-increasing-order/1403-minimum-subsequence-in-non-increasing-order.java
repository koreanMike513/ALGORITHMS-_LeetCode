class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int sum1 = 0, sum2 = 0;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            sum1 += num;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (sum2 <= sum1) {
                sum1 -= nums[i];
                sum2 += nums[i];

                list.add(nums[i]);
            }
    
            else {
                break;
            }
        }

        return list;
    }
}