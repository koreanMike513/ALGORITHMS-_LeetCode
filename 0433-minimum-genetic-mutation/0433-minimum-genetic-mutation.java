class Solution {
    public int minMutation(String startGene, String endGene, String[] banks) {
        Set<String> bank = new HashSet<>();
        Set<String> vis = new HashSet<>();
        int steps = 0;
        for (String b : banks) { bank.add(b); }

        char[] cs = new char[] { 'A', 'C', 'G', 'T' };

        Queue<String> qu = new LinkedList<>();

        qu.add(startGene);
        vis.add(startGene);

        while(!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                String current = qu.poll();
                if (current.equals(endGene)) {
                    return steps;
                }
            
                char[] ca = current.toCharArray();
                for (int j = 0; j < ca.length; j++) {
                    char old = ca[j];
                    for (char c : cs) {
                        ca[j] = c;
                        String gene = new String(ca);

                        if (!vis.contains(gene) && bank.contains(gene)) {
                            qu.add(gene);
                            vis.add(gene);
                        }
                    }

                    ca[j] = old;
                }
            }

            steps++;
        }

        return -1;
    }
}