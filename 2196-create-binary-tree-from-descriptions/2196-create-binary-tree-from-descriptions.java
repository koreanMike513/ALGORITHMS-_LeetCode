/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            if (!map.containsKey(description[0])) 
                map.put(description[0], new TreeNode(description[0]));
            
            if (!map.containsKey(description[1]))
                map.put(description[1], new TreeNode(description[1]));

            TreeNode parent = map.get(description[0]);
            TreeNode child  = map.get(description[1]);

            if (description[2] == 1) 
                parent.left = child;
            
            else
                parent.right = child;

            children.add(description[1]);
        }

        List<Integer> root = Arrays.stream(descriptions)
            .map((description) -> description[0])
            .filter((parent) -> !children.contains(parent))
            .collect(Collectors.toList());

        return map.get(root.get(0));
    }
}