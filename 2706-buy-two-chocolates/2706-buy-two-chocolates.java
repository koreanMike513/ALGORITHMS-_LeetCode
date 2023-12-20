class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = 101, min2 = 101;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min1) {
                min2 = min1;
                min1 = prices[i];
            }

            else if (prices[i] < min2) {
                min2 = prices[i];
            }
        }

        return (min1 + min2 > money) ? money : money - (min1 + min2);
    }
}