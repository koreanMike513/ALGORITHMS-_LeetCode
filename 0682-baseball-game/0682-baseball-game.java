class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0, prev = 0;

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")) {
                stack.pop();
            }

            else if (operations[i].equals("D")) {
                stack.push(stack.peek() * 2);
            }

            else if (operations[i].equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.peek();
                
                stack.push(temp1);
                stack.push(temp1 + temp2);
            }
            else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }

        for (int val: stack) { sum += val; }

        return sum;
    }
}