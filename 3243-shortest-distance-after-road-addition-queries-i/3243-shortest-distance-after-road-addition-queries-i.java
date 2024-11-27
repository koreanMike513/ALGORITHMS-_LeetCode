class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> graphs = new HashMap<>();
        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < n - 1; i++) {
            graphs.put(i, new ArrayList<>());
            graphs.get(i).add(i + 1);
        }

        for (int i = 0; i < m; i++) {
            graphs.get(queries[i][0]).add(queries[i][1]);
            ans[i] = findShortestDistanceAfterQueries(graphs, new boolean[n]);
        }

        return ans;
    }

    private int findShortestDistanceAfterQueries(
        Map<Integer, List<Integer>> graphs,
        boolean[] vis
        ) {
            Queue<Integer> qu = new LinkedList<>();
            int travels = 0;

            qu.add(0);

            while(!qu.isEmpty()) {
                int size = qu.size();

                for (int i = 0; i < size; i++) {
                    int current = qu.poll();

                    if (current == vis.length - 1)
                        return travels;
                    
                    if (vis[current])
                        continue;
                    
                    vis[current] = true;

                    for(int next : graphs.get(current))
                        qu.add(next);
                }

                travels++;
            }

            return -1;
    }
}