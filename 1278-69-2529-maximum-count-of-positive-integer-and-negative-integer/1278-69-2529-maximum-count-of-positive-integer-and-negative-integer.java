class Solution {
    public int maximumCount(int[] nums) {
        int t   = findPos(nums);
        int neg = findNeg(nums) + 1;
        int pos = (t != -1) ? nums.length - t : -1;

        return Math.max(neg, pos);
    }

    private int findNeg(int[] nums) {
        int start = 0, end = nums.length - 1, idx = -1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int n = nums[mid];

            if (n >= 0) {
                end = mid - 1;
            } 

            else {
                start = mid + 1;
                idx = mid;
            }
        }

        return idx;
    }

    private int findPos(int[] nums) {
        int start = 0, end = nums.length - 1, idx = -1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int n = nums[mid];

            if (n <= 0) {
                start = mid + 1;
            } 

            else {
                end = mid - 1;
                idx = mid;
            }
        }

        return idx;
    }
}