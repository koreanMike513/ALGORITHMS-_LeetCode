class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        backtrack(list, "", 0, 0, n);

        return list;
    }

    public void backtrack(List<String> list, String t, int open, int close, int n) {
        if (open == n && close == n) {
            list.add(t.toString());
            return;
        }

        if (open < n) {
            backtrack(list, t + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(list, t + ")", open, close + 1, n);
        }
    }
}