class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0, m = edges.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                int c = dfs(map, visited, i);
                if (!chk(map, new boolean[n], i, c)) {
                    ans--;
                }
            }
        }

        return ans;
    }

    public boolean chk(Map<Integer, List<Integer>> map, boolean[] visited, int current, int size) {
        visited[current] = true;

        if (map.get(current).size() != size - 1)
            return false;

        boolean res = true;
        for (int neighbours : map.get(current)) {
            if (!visited[neighbours])
                res &= chk(map, visited, neighbours, size);
        }

        return res;
    }

    public int dfs(Map<Integer, List<Integer>> map, boolean[] visited, int current) {
        if (visited[current]) {
            return 0;
        }

        int c = 1; 
        visited[current] = true;

        for (int neighbours : map.get(current)) {
            c += dfs(map, visited, neighbours);
        }

        return c;
    }
}