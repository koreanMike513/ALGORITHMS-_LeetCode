class Solution {
    public long countBadPairs(int[] nums) {
        long badPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int pos = 0; pos < nums.length; pos++) {
            int diff = pos - nums[pos];
            int goodPairsCount = map.getOrDefault(diff, 0);

            badPairs += pos - goodPairsCount;

            map.put(diff, goodPairsCount + 1);
        }

        return badPairs;
    }
}