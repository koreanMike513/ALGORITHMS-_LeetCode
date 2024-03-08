class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int segment[]: segments) {
            map.put(segment[0], map.getOrDefault(segment[0], 0L) + segment[2]);
            map.put(segment[1], map.getOrDefault(segment[1], 0L) - segment[2]);
        }

        List<List<Long>> result = new ArrayList<>();

        int prev = 0;
        long sum = 0;

        for (int key: map.keySet()) {
            if (sum != 0) { 
                result.add(Arrays.asList((long) prev, (long) key, sum));
            }

            sum += map.get(key);
            prev = key;
        }

        return result;
    }
}