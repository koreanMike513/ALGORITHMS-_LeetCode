class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return helper(new HashMap<>(), nums, k, 0);
    }

    public int helper(Map<Integer, Integer> current, int[] nums, int k, int idx) {
        for (int c : current.keySet()) {
            if (current.containsKey(c - k) || current.containsKey(c + k)) 
                return 0;
        }

        if (idx >= nums.length) {
            return (!current.isEmpty()) ? 1 : 0;
        }

        current.put(nums[idx], current.getOrDefault(nums[idx], 0) + 1);
        int take = helper(current, nums, k, idx + 1);

        current.put(nums[idx], current.getOrDefault(nums[idx], 0) - 1);

        if (current.get(nums[idx]) <= 0)
            current.remove(nums[idx]);

        int notTake = helper(current, nums, k, idx + 1);

        return take + notTake;
    }
}