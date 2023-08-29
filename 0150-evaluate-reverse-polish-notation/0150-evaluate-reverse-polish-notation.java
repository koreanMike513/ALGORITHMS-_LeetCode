class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (!stack.isEmpty() && tokens[i].equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                    
                stack.push(a + b);
            }

            else if (!stack.isEmpty() && tokens[i].equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                    
                stack.push(a - b);
            }

            else if (!stack.isEmpty() && tokens[i].equals("*")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a * b);
            }

            else if (!stack.isEmpty() && tokens[i].equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                    
                stack.push(a / b);
            }

            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}