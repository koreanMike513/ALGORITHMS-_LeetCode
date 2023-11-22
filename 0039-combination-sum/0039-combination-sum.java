class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> t, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        }

        else if (remain == 0) {
            list.add(new ArrayList<>(t));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            t.add(candidates[i]);
            backtrack(list, t, candidates, remain - candidates[i], i);
            t.remove(t.size() - 1);
        }
    }
}