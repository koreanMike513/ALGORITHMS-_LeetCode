class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();

        for (int i = 0; i < matches.length; i++) {
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
        }

        for (int i = 0; i < matches.length; i++) {
            if (!map.containsKey(matches[i][0])) {
                winners.add(matches[i][0]);
            }

            if (map.get(matches[i][1]) == 1) {
                losers.add(matches[i][1]);
            }
        }

        List<Integer> wa = new ArrayList<>(winners);
        List<Integer> la = new ArrayList<>(losers);

        Collections.sort(wa);
        Collections.sort(la);
        
        ans.add(wa);
        ans.add(la);

        return ans;
    }
}