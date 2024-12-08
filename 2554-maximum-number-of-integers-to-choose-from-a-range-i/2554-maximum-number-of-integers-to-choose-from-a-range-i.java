class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> ban = new HashSet<>();
        int ans = 0;

        for (int b : banned) {
            ban.add(b);
        }

        for (int i = 1; i <= n && maxSum >= 0; i++) {
            if (!ban.contains(i) && maxSum - i >= 0) {
                maxSum -= i;
                ans++;
            }
        }

        return ans;
    }
}