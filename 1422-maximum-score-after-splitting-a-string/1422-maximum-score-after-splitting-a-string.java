class Solution {
    public int maxScore(String s) {
        int zero = 0, one = 0, n = s.length(), ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') one++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') zero++;
            else one--;

            ans = Math.max(ans, zero + one);
        }

        return ans;
    }
}