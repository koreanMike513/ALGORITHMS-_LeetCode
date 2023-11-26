class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(list, new ArrayList<>(), candidates, target, 0);

        return list;
    }

    public void backtrack (List<List<Integer>> list, List<Integer> t, int[] candidates, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(t));
            return;
        }

        boolean[] visited = new boolean[50];

        for (int i = start; i < candidates.length; i++) {
            if (!visited[candidates[i]] && target - candidates[i] >= 0) {
                visited[candidates[i]] = true;
                t.add(candidates[i]);
                backtrack(list, t, candidates, target - candidates[i], i + 1);
                t.remove(t.size() - 1);
            }
        }
    }
}
