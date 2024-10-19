class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, start = 0, end = n - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }

            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }    
            }
        }

        return (nums[start] == target) ? start : -1;
    }
}