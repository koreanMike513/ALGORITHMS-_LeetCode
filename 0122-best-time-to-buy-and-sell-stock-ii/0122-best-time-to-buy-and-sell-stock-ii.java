class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, current = prices[0]; 

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > current) {
                profit += prices[i] - current;
                current = prices[i];
            }

            else {
                current = prices[i];
            }
        }

        return profit;
    }
}