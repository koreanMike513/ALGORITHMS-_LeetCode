class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length, start = 0, end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int current = nums[mid];
            int l = (mid > 0) ? nums[mid - 1] : Integer.MIN_VALUE;
            int r = (mid < n - 1) ? nums[mid + 1] : Integer.MIN_VALUE;

            if (l < nums[mid] && nums[mid] > r)
                return mid;
            
            if (l <= nums[mid] && nums[mid] < r)
                start = mid + 1;

            else
                end = mid - 1;
        }

        return start;
    }
}