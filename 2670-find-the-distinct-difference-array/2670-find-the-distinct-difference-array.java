class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num : nums) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i], map1.get(nums[i]) - 1);
            map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);

            if (map1.get(nums[i]) <= 0) {
                map1.remove(nums[i]);
            }
            
            nums[i] = map2.size() - map1.size();
        }

        return nums;
    }
}