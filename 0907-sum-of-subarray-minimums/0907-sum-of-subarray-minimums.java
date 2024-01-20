class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        long ans = 0, M = (long)1e9 + 7;
        st.push(-1);

        for (int i = 0; i < arr.length + 1; i++) {
            int current = (i < arr.length) ? arr[i] : 0;

            while (st.peek() != -1 && arr[st.peek()] > current) {
                int j = st.pop();
                int left = j - st.peek();
                int right = i - j;
                ans += (long) ((long) arr[j] * left * right) % M;
                ans %= M;
            }

            st.push(i);
        }

        return (int) (ans);
    }
}