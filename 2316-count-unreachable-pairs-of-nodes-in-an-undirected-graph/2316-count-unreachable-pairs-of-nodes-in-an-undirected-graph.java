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
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }

        Map<Integer, List<Long>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = uf.find(i);

            if (!map.containsKey(root)) {
                map.put(root, new ArrayList<>());
            }

            map.get(root).add(i + 0L);
        } 

        long total = n * (n - 1L) / 2, connectedPairs = 0;

        for (List<Long> value : map.values()) {
            long i = value.size();
            connectedPairs += i * (i - 1) / 2;
        }

        return total - connectedPairs;
    }
}