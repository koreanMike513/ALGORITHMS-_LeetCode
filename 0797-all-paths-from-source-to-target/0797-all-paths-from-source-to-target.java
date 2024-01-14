class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> t = new ArrayList<>();

        t.add(0);
        allPathsSourceTarget(graph, list, t, 0);

        return list;
    }

    public void allPathsSourceTarget(int[][] graph, List<List<Integer>> list, List<Integer> t, int start) {
        if (start == graph.length - 1) {
            list.add(new ArrayList<>(t));
            return;
        }

        for (int i : graph[start]) {
            t.add(i);
            allPathsSourceTarget(graph, list, t, i);
            t.remove(t.size() - 1);
        }
    }
}