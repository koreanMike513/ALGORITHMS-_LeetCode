class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] networks = new HashSet[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            networks[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < roads.length; i++) {
            networks[roads[i][0]].add(roads[i][1]);
            networks[roads[i][1]].add(roads[i][0]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = networks[i].size() + networks[j].size();
                t -= (networks[i].contains(j)) ? 1 : 0;
                ans = Math.max(ans, t);
            }
        }

        return ans;
    }
}