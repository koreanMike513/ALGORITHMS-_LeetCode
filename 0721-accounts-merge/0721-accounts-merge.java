class UnionFind {

    int[] parent;
    int[] weight;

    public UnionFind(int n) {
        parent = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = (n - i);
        }
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (weight[rootA] > weight[rootB]) {
            parent[rootB] = rootA;
        }

        else {
            parent[rootA] = rootB;
        }
    }

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);

        Map<String, Integer> emailToID = new HashMap<>();

        for (int i = 0; i < size; i++) {
            List<String> details = accounts.get(i);
            
            for (int j = 1; j < details.size(); j++) {
                String email = details.get(j);

                if (emailToID.containsKey(email)) {
                    uf.union(i, emailToID.get(email));
                }
                else {
                    emailToID.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> idToEmail = new HashMap<>();

        for (String email : emailToID.keySet()) {
            int root = uf.find(emailToID.get(email));

            if (!idToEmail.containsKey(root)) {
                idToEmail.put(root, new ArrayList<String>());
            }

            idToEmail.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int id : idToEmail.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(id).get(0));
            Collections.sort(idToEmail.get(id));
            merged.addAll(idToEmail.get(id));
            ans.add(merged);
        }

        return ans;
    }
}