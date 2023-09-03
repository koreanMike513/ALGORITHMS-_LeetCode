class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder(s);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            }
                
            else if (c == ')') {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
                    st.pop();
                }

                else {
                    st.push(i);
                }
            }
        }
        
        while (!st.isEmpty()) {
            ans.deleteCharAt(st.pop());
        }
        
        return ans.toString();
    }
}