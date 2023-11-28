class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();

        backtrack(list, new ArrayList<>(), k, n, 1);

        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> t, int k, int n, int start) {
        if (n < 0 || t.size() > k) {
            return;
        }

        if (n == 0 && t.size() == k) {
            list.add(new ArrayList<>(t));
            return;
        }

        for (int i = start; i < 10; i++) {
            t.add(i);
            backtrack(list, t, k, n - i, i + 1);
            t.remove(t.size() - 1);
        }
    }
}