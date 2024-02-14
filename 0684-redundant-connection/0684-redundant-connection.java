class UnionFind {

    int[] parents;

    public UnionFind(int n) {
        parents = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (rootA < rootB) {
            parents[rootB] = rootA;
        }

        else {
            parents[rootA] = rootB;
        }
    }

    public int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            int a = uf.find(edges[i][0]);
            int b = uf.find(edges[i][1]);

            if (a == b) {
                return edges[i];
            }

            uf.union(a, b);
        }

        return new int[] { -1, -1 };
    }
}