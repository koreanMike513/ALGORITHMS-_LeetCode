class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}

class MyCircularDeque {
    int capacity;
    int current;
    Node head;
    Node tail;

    public MyCircularDeque(int k) {
        capacity = k;
        current = 0;
    }
    
    public boolean insertFront(int value) {
        if (current >= capacity) {
            return false;
        }

        if (head == null) {
            head = new Node(value);
            tail = head;
            current++;

            return true;
        }

        Node node = new Node(value);
        node.next = head;
        head.prev = node;
        head = node;
        current++;

        return true;
    }
    
    public boolean insertLast(int value) {
        if (current >= capacity) {
            return false;
        }

        if (tail == null) {
            tail = new Node(value);
            head = tail;
            current++;

            return true;
        }

        Node node = new Node(value);
        node.prev = tail;
        tail.next = node;
        tail = node;
        current++;

        return true;
    }
    
    public boolean deleteFront() {
        if (head == null) {
            return false;
        }

        if (current == 1) {
            head = null;
            tail = null;
            current--;

            return true;
        }

        Node delete = head;
        Node newHead = head.next;
        delete.next = null;
        newHead.prev = null;
        head = newHead;
        current--;

        return true;
    }
    
    public boolean deleteLast() {
        if (tail == null) {
            return false;
        }

        if (current == 1) {
            head = null;
            tail = null;
            current--;

            return true;
        }

        Node delete = tail;
        Node newtail = tail.prev;
        delete.prev = null;
        newtail.next = null;
        tail = newtail;
        current--;

        return true;
    }
    
    public int getFront() {
        if (head == null) {
            return -1;
        }

        return head.val;
    }
    
    public int getRear() {
        if (tail == null) {
            return -1;
        }

        return tail.val;
    }
    
    public boolean isEmpty() {
        return current == 0;
    }
    
    public boolean isFull() {
        return current >= capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */