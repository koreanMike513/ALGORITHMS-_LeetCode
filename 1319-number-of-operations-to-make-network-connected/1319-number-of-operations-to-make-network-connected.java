class UnionFind {
    int[] parents;

    public UnionFind(int n) {
        parents = new int[n];

        for (int i = 0; i < n; i++) {
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
    public int makeConnected(int n, int[][] connections) {
        int ans = 0, cables = 0;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < connections.length; i++) {
            if (uf.find(connections[i][0]) == uf.find(connections[i][1])) {
                cables++;
            }
    
            uf.union(connections[i][0], connections[i][1]);
        }

        for (int i = 1; i < n; i++) {
            if (uf.find(i) == i) {
                ans++;
                cables--;
            }
        }

        return (cables >= 0) ? ans : -1;
    }
}