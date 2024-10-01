/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();

        return cloneNodes(map, node);
    }

    private Node cloneNodes(Map<Integer, Node> map, Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node(node.val);
        map.put(node.val, clone);
        
        for (Node neighbour : node.neighbors) {
            clone.neighbors.add(cloneNodes(map, neighbour)); 
        }

        return clone;
    }
}