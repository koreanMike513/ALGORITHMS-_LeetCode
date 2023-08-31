class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sk = new Stack<>();
        Stack<Character> tk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!sk.isEmpty() && c == '#') {
                sk.pop();
            }

            else if (c != '#') {
                sk.push(c);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (!tk.isEmpty() && c == '#') {
                tk.pop();
            }

            else if (c != '#') {
                tk.push(c);
            }
        }

        while (!sk.isEmpty() && !tk.isEmpty()) {
            if (sk.pop() != tk.pop()) return false;
        }

        return (sk.isEmpty() && tk.isEmpty());
    }
}