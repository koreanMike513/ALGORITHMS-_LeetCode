class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long ans = 0;

        Arrays.sort(nums);

        // 0 1 4 4 5 7

        for (int i = 0; i < n; i++) {
            int end = binarySearch(nums, i + 1, upper + 1 - nums[i]);
            int start = binarySearch(nums, i + 1, lower - nums[i]);
        
            ans += (end - start);
        }

        return ans;
    }

    private int binarySearch(int[] nums, int start, int bound) {
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] < bound) {
                start = mid + 1;
            }
            
            else if (nums[mid] >= bound)
                end = mid - 1;
        }

        return start;
    }
}