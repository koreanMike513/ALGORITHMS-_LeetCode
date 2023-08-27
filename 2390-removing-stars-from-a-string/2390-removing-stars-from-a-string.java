class Solution {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.length() > 0 && c == '*') {
                stack.deleteCharAt(stack.length() - 1);
            }

            else {
                stack.append(c);
            }
        }

        return stack.toString();
    }
}