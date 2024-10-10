class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parents = new HashMap<>();
        Map<Integer, Integer> depth = new HashMap<>(); 

        DFS(parents, depth, root, null, 1);

        return LCA(parents, depth, p, q);
    }

    private void DFS(Map<Integer, TreeNode> parents, Map<Integer, Integer> depth, TreeNode node, TreeNode parent, int currentDepth) {  
        if (node == null || parents.containsKey(node.val)) {
            return;
        }

        parents.put(node.val, parent);
        depth.put(node.val, currentDepth);

        DFS(parents, depth, node.left, node, currentDepth + 1);
        DFS(parents, depth, node.right, node, currentDepth + 1);
    }

    private TreeNode LCA(Map<Integer, TreeNode> parents, Map<Integer, Integer> depth, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }

        if (depth.get(p.val) < depth.get(q.val)) {
            return LCA(parents, depth, p, parents.get(q.val));
        }

        else if (depth.get(p.val) > depth.get(q.val)) {
            return LCA(parents, depth, parents.get(p.val), q);
        }

        return LCA(parents, depth, parents.get(p.val), parents.get(q.val));
    }
}