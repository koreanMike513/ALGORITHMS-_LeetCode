/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Queue<Node> qu = new LinkedList<>();
        Stack<Node> st = new Stack<>();

        qu.add(root);

        while (!qu.isEmpty()) {
            int level = qu.size();
            Node t1 = qu.poll();

            if (t1.left != null) { 
                qu.add(t1.left);
            }

            if (t1.right != null) {
                qu.add(t1.right);
            }
            
            for (int i = 1; i < level; i++) {
                Node t2 = qu.poll();
                t1.next = t2;
 
                if (t2.left != null) {
                    qu.add(t2.left);
                }

                if (t2.right != null) {
                    qu.add(t2.right);
                }

                t1 = t2;
            }

            t1.next = null;
        }

        return root;
    }
}