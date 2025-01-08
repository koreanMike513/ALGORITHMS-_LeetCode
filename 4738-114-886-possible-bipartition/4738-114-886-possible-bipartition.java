class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        int[] colors = new int[n + 1];

        for (int node = 1; node <= n; node++) {
            if (colors[node] == 0 && !paint(colors, node, graph, 1)) 
                return false;
        }

        return true;
    }

    private boolean paint(int[] colors, int node, List<Integer>[] graph, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int adj : graph[node]) {
            if (!paint(colors, adj, graph, -color)) {
                return false;
            }
        }

        return true;
    }
}