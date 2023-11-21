class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int[] squares = new int[(int) Math.sqrt(n)];

        Arrays.fill(dp, 10001);

        for (int i = 0; i < squares.length; i++) {
            squares[i] = (int) Math.pow(i + 1, 2);
        }

        for (int i = 0; i < squares.length; i++) {
            dp[squares[i]] = 1; 
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (i - squares[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
                }
            }
        }

        return dp[n];
    }
}