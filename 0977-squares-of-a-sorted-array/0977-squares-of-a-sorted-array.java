class Solution {
    public int[] sortedSquares(int[] nums) {

        int[] ans = new int[nums.length];
    
        int left = 0, right = nums.length - 1, idx = nums.length - 1;

        while (left <= right) {
            int n1 = nums[left] * nums[left];
            int n2 = nums[right] * nums[right];

            if (n1 < n2) {
                ans[idx--] = n2;
                right--;
            }

            else {
                ans[idx--] = n1;
                left++;
            }
        }

        return ans;
    }
}