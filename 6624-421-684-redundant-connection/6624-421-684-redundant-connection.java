class Union {
    public int[] parents;

    public Union(int n) {
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        if (rootA < rootB) {
            parents[rootB] = rootA;
        }

        else {
            parents[rootA] = rootB;
        }
    }


    public int find(int a) {
        if (a == parents[a])
            return a;
        
        return parents[a] = find(parents[a]);
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        Union u = new Union(n);

        for (int[] edge : edges) {
            int a = u.find(edge[0]);
            int b = u.find(edge[1]);

            if (a == b)
                return edge;

            u.union(edge[0], edge[1]);
        }

        return new int[]{};
    }
}