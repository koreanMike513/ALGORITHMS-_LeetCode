class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, new HashMap<>(), target, 0);
    }

    public int findTargetSumWays(int[] nums, Map<String, Integer> map, int target, int idx) {
        if (idx >= nums.length) {
            return (target == 0) ? 1 : 0;
        }

        String key = target + "()" + idx;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int count = (
            findTargetSumWays(nums, map, target - nums[idx], idx + 1) + 
            findTargetSumWays(nums, map, target + nums[idx], idx + 1)
        );

        map.put(key, count);

        return count;
    }
}