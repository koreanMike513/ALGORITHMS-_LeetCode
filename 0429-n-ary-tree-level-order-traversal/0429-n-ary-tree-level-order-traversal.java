/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> qu = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) return levels;

        qu.add(root);

        while (!qu.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int lv = qu.size();

            for (int i = 0; i < lv; i++) {
                Node t = qu.poll();

                level.add(t.val);

                if (t.children != null) {
                    for (Node child : t.children) {
                        qu.add(child);
                    }
                }
            }

            levels.add(level);
        }

        return levels;
    }
}