class UnionFind {

    int[] parent;

    public UnionFind() {
        parent = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
    }

    public void union(char a, char b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (rootA < rootB) {
            parent[rootB] = rootA;
        }

        else {
            parent[rootA] = rootB;
        }
    }

    public int find(char a) {
        if (parent[a - 'a'] == (a - 'a')) {
            return parent[a - 'a'];
        }

        return parent[a - 'a'] = find((char) (parent[a - 'a'] + 'a'));
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind();

        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i), s2.charAt(i));
        }

        char[] ca = baseStr.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            ca[i] = (char) (uf.find(ca[i]) + 'a');
        }

        return new String(ca);
    }
}