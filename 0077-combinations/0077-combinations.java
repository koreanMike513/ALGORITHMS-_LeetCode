class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        
        backtrack(list, new ArrayList<Integer>(), n, k, 1);

        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> t, int n, int k, int start) {
        if (t.size() == k) {
            list.add(new ArrayList<>(t));
            return;
        }

        for (int i = start; i <= n; i++) {
            t.add(i);
            backtrack(list, t, n, k, i + 1);
            t.remove(t.size() - 1);
        }
    }
}