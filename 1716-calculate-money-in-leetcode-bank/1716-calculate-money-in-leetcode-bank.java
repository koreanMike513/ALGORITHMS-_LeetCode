class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int[] days = new int[n];

        days[0] = 1;

        for (int i = 1; i < n; i++) {
            days[i] = (i % 7 == 0) ? days[i - 7] + 1 : days[i - 1] + 1;
        }

        for (int i = 0; i < n; i++) {
            ans += days[i];
        }

        return ans;
    }
}