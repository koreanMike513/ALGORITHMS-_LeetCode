class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;

        for (int[] account: accounts) {
            int t = 0;
            for (int i = 0; i < account.length; i++) {
                t += account[i];
            }

            if (t > wealth) wealth = t;
        }

        return wealth;
    }
}