class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int current = 0, ans = 0, n = cardPoints.length;

        if (k >= n) {
            return Arrays.stream(cardPoints).sum();
        }

        for (int i = 0; i < k; i++) {
            current += cardPoints[i];
        }

        ans = current;

        for (int i = k - 1; i >= 0; i--) {
            current = current - cardPoints[i] + cardPoints[n - k + i];
            ans = Math.max(ans, current);
        }

        return ans;
    }
}