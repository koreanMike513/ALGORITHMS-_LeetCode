class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        Arrays.sort(nums);

        for (int n : nums) {
            if (map.containsKey(n))
                continue;

            int key = (int) Math.sqrt(n);

            if (map.containsKey(key) && ((int) Math.pow(key, 2) == n)) {
                map.get(key).add(n);
                map.put(n, new ArrayList<>(map.get(key)));
                map.remove(key);
            }

            else {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                map.put(n, list);
            }
        }

        int maxSubsequence = 0;

        for (List<Integer> value : map.values()) {
            maxSubsequence = Math.max(maxSubsequence, value.size());
        }

        return (maxSubsequence == 1) ? -1 : maxSubsequence;
    }
}