class MinStack {
    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();

    public MinStack() {
        
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        
        stack.push(val);
    }


    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();     
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}