class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int n = queries.size();
        double[] ans = new double[n];

        for (int i = 0; i < equations.size(); i++) {
            String nominator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);

            if (!map.containsKey(nominator))
                map.put(nominator, new HashMap<>());

            if (!map.containsKey(denominator))
                map.put(denominator, new HashMap<>());

            map.get(nominator).put(denominator, values[i]);
            map.get(denominator).put(nominator, (1.0 / values[i]));
        }

        for (int i = 0; i < n; i++) {
            ans[i] = calcEquation(map, new HashSet<>(), queries.get(i).get(1), queries.get(i).get(0));
        }

        return ans;
    }

    private double calcEquation(Map<String, Map<String, Double>> map, Set<String> vis, String target, String current) {
        if (map.get(current) == null)
            return -1.0;
        
        if (current.equals(target)) {
            return 1.0;
        }

        double cal = -1.0;

        for (String denominator : map.get(current).keySet()) {
            if (!vis.contains(denominator)) {
                vis.add(denominator);
                cal = Math.max(cal, map.get(current).get(denominator) * calcEquation(map, vis, target, denominator));
                vis.remove(denominator);
            }
        }

        return (cal > 0) ? cal : -1;
    }
}