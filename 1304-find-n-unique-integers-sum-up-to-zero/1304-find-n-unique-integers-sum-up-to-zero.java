class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int idx = (n % 2 == 1) ? 1 : 0;

        for (int i = idx; i < n; i += 2) {
            ans[i] = i + 1;
            ans[i + 1] = -i - 1;
        }

        return ans;
    }
}