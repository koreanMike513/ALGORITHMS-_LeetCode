class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();

        return helper(s, set, 0);
    }

    private int helper(String s, Set<String> set, int idx) {
        if (idx >= s.length()) {
            return set.size();
        }

        int res = 0;

        for (int i = idx + 1; i <= s.length(); i++) {
            if (!set.contains(s.substring(idx, i))) {
                set.add(s.substring(idx, i));
                res = Math.max(res, helper(s, set, i));
                set.remove(s.substring(idx, i));
            }
        }

        return res;
    }
}