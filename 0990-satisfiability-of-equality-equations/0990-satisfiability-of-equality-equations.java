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
        if (parent[a - 'a'] == a - 'a') {
            return a - 'a';
        }

        return parent[a - 'a'] = find((char) (parent[a - 'a'] + 'a'));
    }
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf.union(equation.charAt(0), equation.charAt(3));
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!' && uf.find(equation.charAt(0)) == uf.find(equation.charAt(3))) {
                return false;                    
            }
        }


        return true;
    }
}