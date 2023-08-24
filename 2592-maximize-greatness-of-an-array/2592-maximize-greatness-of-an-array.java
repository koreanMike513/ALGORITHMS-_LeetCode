class Solution {
    public int maximizeGreatness(int[] nums) {
        int j = 0, count = 0;
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                if (nums[j] > nums[i]) {
                    count++; j++;
                    break;
                }

                j++;
            }
        }

        return count;
    }
}