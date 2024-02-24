class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, ans = 0;
        
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % k;

            if (prefixSum < 0) prefixSum += k;
            if (map.containsKey(prefixSum)) ans += map.get(prefixSum);
            
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }
}