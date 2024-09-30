class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}

class CustomStack {
    int capacity;
    int current;
    Node top;
    Node bottom;

    public CustomStack(int maxSize) {
        capacity = maxSize;
        current = 0;
    }
    
    public void push(int x) {
        if (current >= capacity) {
            return;
        }

        if (current == 0) {
            top = new Node(x);
            bottom = top;
            current++;

            return;
        }

        Node node = new Node(x);
        node.prev = top;
        top.next = node;
        top = node;

        current++;
    }
    
    public int pop() {
        if (current <= 0) {
            return -1;
        }

        if (current == 1) {
            Node remove = top;
            
            bottom = null;
            top = null;
            current--;

            return remove.val;
        }

        Node remove = top;
        top = top.prev;
        top.next = null;
        remove.prev = null;

        current--;

        return remove.val;
    }
    
    public void increment(int k, int val) {
        Node c = bottom;

        for (int i = 0; i < k && c != null; i++) {
            c.val += val;
            c = c.next;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */