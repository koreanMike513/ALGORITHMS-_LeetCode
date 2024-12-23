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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        int swaps = 0;

        qu.add(root);

        while(!qu.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();

                list.add(node.val);

                if (node.left != null)
                    qu.add(node.left);
                
                if (node.right != null)
                    qu.add(node.right);
            }

            swaps += calculateSwaps(list);
        }

        return swaps;
    }

    private int calculateSwaps(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>(list);
        Map<Integer, Integer> pos = new HashMap<>();
        int swaps = 0;
        
        Collections.sort(sorted);

        for (int i = 0; i < list.size(); i++) {
            pos.put(list.get(i), i);
        }
            
        for (int i = 0; i < sorted.size(); i++) {
            if (!sorted.get(i).equals(list.get(i))) {
                int idx = pos.get(sorted.get(i));
                int t = list.get(i);

                list.set(idx, t);
                list.set(i, sorted.get(i));

                pos.put(t, idx);
                pos.put(sorted.get(i), i);
                    
                swaps++;
            }
        }

        return swaps;
    }
}