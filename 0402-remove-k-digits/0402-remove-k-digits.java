class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";

        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && num.charAt(stack.peek()) > num.charAt(i)) {
                k--; stack.pop();
            }

            if (stack.size() == 1 && num.charAt(stack.peek()) == '0' && num.charAt(i) >= 0) {
                stack.pop();
            }

            stack.push(i);
        }

        for (int j = 0; j < k; j++) {
            if (!stack.isEmpty()) stack.pop();
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(num.charAt(stack.pop()));
        }

        return (sb.length() == 0) ? "0" : sb.reverse().toString();
    }
}