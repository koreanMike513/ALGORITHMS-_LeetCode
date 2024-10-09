class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length(), open = 0, closed = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (!st.isEmpty() && c == ']' && st.peek() == '[') {
                st.pop();
                continue;
            }

            st.push(c);
        }

        return ((st.size() / 2) + 1) / 2;
    }
}