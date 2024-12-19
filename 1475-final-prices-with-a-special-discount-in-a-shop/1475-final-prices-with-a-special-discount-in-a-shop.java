class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int n = prices.length;
        int[] ans = Arrays.copyOf(prices, n);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                int idx = st.pop();
                ans[idx] = prices[idx] - prices[i];
            }
            
            st.push(i);
        }

        return ans;
    }
}