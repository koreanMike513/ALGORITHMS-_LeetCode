/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<TreeNode> vis = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> neighbours = new HashMap<>();

        if (root == null) {
            return ans;
        }

        if (k == 0) {
            ans.add(target.val);
            return ans;
        }

        buildGraph(neighbours, root, null);

        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(target);
        vis.add(target);

        while (k > 0) {
            k--;
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = qu.poll();
                List<TreeNode> currentNeighbours = neighbours.get(current);
                
                for (TreeNode neighbour : currentNeighbours) {
                    if (!vis.contains(neighbour)) {
                        if (k == 0) {
                            ans.add(neighbour.val);
                        }

                        vis.add(neighbour);
                        qu.add(neighbour);
                    }
                }
            }
        }

        return ans;
    }

    public void buildGraph(Map<TreeNode, List<TreeNode>> neighbours, TreeNode current, TreeNode prev) {
        if (current == null || neighbours.containsKey(current)) {
            return;
        }

        neighbours.put(current, new ArrayList<TreeNode>());

        if (prev != null) {
            neighbours.get(current).add(prev);
            neighbours.get(prev).add(current);
        }

        buildGraph(neighbours, current.left, current);
        buildGraph(neighbours, current.right, current);
    }
}