class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!st.isEmpty() && c == ')') {
                sb = new StringBuilder();

                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }

                st.pop();

                int k = 0;

                while (k < sb.length()) {
                    st.push(sb.charAt(k++));
                }
            }

            else {
                st.push(c);
            }
        }

        sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}