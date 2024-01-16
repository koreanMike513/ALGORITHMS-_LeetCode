class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (List<Integer> edge : edges) {
            visited[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}