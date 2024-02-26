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
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        pairs.forEach(pair -> uf.union(pair.get(0), pair.get(1)));

        return createSmallestString(s, createComponents(s, uf), uf);
    }

        private Map<Integer, PriorityQueue<Character>> createComponents(String s, UnionFind uf) {
            Map<Integer, PriorityQueue<Character>> components = new HashMap<>();
            
            for (int vertex = 0; vertex < s.length(); vertex++) {
                int root = uf.find(vertex);
                components.putIfAbsent(root, new PriorityQueue<>());
                components.get(root).offer(s.charAt(vertex));
            }

            return components;
    }

    private String createSmallestString(String s, Map<Integer, PriorityQueue<Character>> components, UnionFind uf) {
        StringBuilder smallest = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            smallest.append(components.get(uf.find(i)).poll());
        }

        return smallest.toString();
    }
}