class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder stack = new StringBuilder();
        Stack<Integer> count = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cc = 1;

            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == s.charAt(i)) {
                cc = count.peek() + 1;
            }

            stack.append(c);
            count.push(cc);

            if (!count.isEmpty() && count.peek() == k) {
                char dc = stack.charAt(stack.length() - 1);

                while (stack.length() > 0 && stack.charAt(stack.length() - 1) == dc) {
                    stack.deleteCharAt(stack.length() - 1);
                    count.pop();
                }
            }
        }
        return stack.toString();
    }
}