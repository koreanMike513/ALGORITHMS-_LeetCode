class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colours = new int[n];

        Arrays.fill(colours, -1);

        for (int i = 0; i < n; i++) {
            if (colours[i] == -1 && !validColour(graph, colours, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean validColour(int[][] graph, int[] colours, int node) {
        colours[node] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int neighbour : graph[current]) {
   
                if (colours[neighbour] == colours[current]) {
                    return false;
                }

                if (colours[neighbour] == -1) {
                    colours[neighbour] = 1 - colours[current];
                    q.add(neighbour);
                }
            }
        }

        return true;
    }
}