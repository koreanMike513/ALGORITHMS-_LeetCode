class Solution {
    public int minOperations(int[] nums, int x) {
        
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0, target = -x, len = 0;

        for (int num: nums) { target += num; }

        if (target == 0) return nums.length;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - target)) {
                len = Math.max(len, i - map.get(sum - target));  
            }

            map.put(sum, i);
        }

        return (len == 0) ? -1 : nums.length - len;
    }
}