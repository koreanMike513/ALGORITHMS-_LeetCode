class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];
        int m = rolls.length, sum = mean * (m + n);

        for (int roll : rolls) {
            sum -= roll;
        }

        if (sum / n == 0 || sum / n > 6 || sum / n >= 6 && sum % n > 0 || sum < 0)
            return new int[]{};

        for (int i = 0; i < n; i++) {
            ans[i] = sum / n;
        }

        int remainder = sum % n;

        while (remainder > 0) {
            for (int i = 0; i < n && remainder > 0; i++, remainder--) {
                ans[i] += 1;
            }
        }

        return ans;
    }
}