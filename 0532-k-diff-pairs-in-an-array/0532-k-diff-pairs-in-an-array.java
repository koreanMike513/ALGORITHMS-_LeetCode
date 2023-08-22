class Solution {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums); 

        int l = 0, ans = 0, prev = Integer.MAX_VALUE;

        for (int r = 1; r < nums.length; r++) {

            while (l < r && nums[r] - nums[l] > k) l++;

            if (l != r && nums[l] != prev && nums[r] - nums[l] == k) {
                prev = nums[l];
                ans++;
            }
        }

        return ans;
    }
}