class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0, ans = 0;
        int n = nums.length;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = k; i < n; i++) {
            if (map.size() == k)
                ans = Math.max(ans, sum);

            sum += nums[i];
            sum -= nums[i - k];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[i - k], map.getOrDefault(nums[i - k], 0) - 1);

            if (map.get(nums[i - k]) == 0)
                map.remove(nums[i - k]);
        }

        if (map.size() == k)
            ans = Math.max(ans, sum);

        return ans;
    }
}