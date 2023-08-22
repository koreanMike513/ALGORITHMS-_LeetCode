class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) return new int[] { -1, -1 };
        
        return new int[] { searchFirst(nums, target), searchLast(nums, target) };
    }

    public int searchFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0, current = - 1;

        while (left <= right) {
            mid = (right + left) / 2;

            if (nums[mid] == target) {
                current = mid;
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return current;
    }

    public int searchLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0, current = - 1;

        while (left <= right) {
            mid = (right + left) / 2;

            if (nums[mid] == target) {
                current = mid;
                left = mid + 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return current;
    }
}