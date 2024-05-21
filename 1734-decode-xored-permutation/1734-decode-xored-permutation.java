class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length, xor = 0;
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n + 1; i++) {
            xor ^= i;
        }

        for (int i = 0; i < n; i += 2) {
            xor ^= encoded[i];
        }

        ans[n] = xor;

        for (int i = n - 1; i >= 0; i--) {
            xor ^= encoded[i];
            ans[i] = xor;
        }

        return ans;
    }
}