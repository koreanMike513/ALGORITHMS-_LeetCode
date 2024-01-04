class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) == 1) {
                return -1;
            }

            int freq = map.get(num);
            ans = ans + (freq / 3) + ((freq % 3 == 0) ? 0 : 1);
        }

        return ans;
    }
}