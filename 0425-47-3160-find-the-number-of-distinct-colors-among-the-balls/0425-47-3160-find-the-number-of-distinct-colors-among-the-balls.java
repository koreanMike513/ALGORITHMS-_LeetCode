class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> balls = new HashMap<>();
        Map<Integer, Set<Integer>> paints = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int[] query = queries[i];

            if (balls.containsKey(query[0])) {
                int paint = balls.get(query[0]);
                paints.get(paint).remove(query[0]);
                
                if (paints.get(paint).size() == 0)
                    paints.remove(paint);
            }

            if (!paints.containsKey(query[1]))
                paints.put(query[1], new HashSet<>());

            paints.get(query[1]).add(query[0]);
            balls.put(query[0], query[1]);

            ans[i] = paints.keySet().size();
        }

        return ans;
    }
}