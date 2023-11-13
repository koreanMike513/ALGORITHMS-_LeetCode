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
        if (root == null) return null;

        Queue<Node> qu = new LinkedList<>();
        qu.add(root);

        while (!qu.isEmpty()) {
            int level = qu.size();
            Node t = null;

            for (int i = 0; i < level; i++) {
                t = qu.poll();
                t.next = qu.peek();

                if (t.left != null) qu.add(t.left);
                if (t.right != null) qu.add(t.right);
            }

            t.next = null;
        }

        return root;
    }
}