class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, ans = 0, min = Integer.MAX_VALUE, max = -1, k = 0;
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (num < min) 
                min = num;
            
            if (num > max) 
                max = num;

            map.put(num, map.getOrDefault(num, 0) + 1);

            while (max - min > limit) {
                int rm = nums[k++];

                map.put(rm, map.get(rm) - 1);

                if (map.get(rm) <= 0)
                    map.remove(rm);
                
                // System.out.println(map.keySet());
                max = map.keySet().stream().max(Integer::compare).get();
                min = map.keySet().stream().min(Integer::compare).get();
            }

            ans = Math.max(ans, i - k + 1);
        }

        return ans;
    }
}