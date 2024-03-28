class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0, n = nums.length;

        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
     
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            right++;
            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}