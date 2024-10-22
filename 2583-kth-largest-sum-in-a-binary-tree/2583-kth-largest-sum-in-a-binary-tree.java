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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long a, Long b) {
                return Long.compare(b, a);
            }
        }); 
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);

        while (!qu.isEmpty()) {
            int size = qu.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();
                
                sum += node.val;

                if (node.left != null) {
                    qu.add(node.left);
                }

                if (node.right != null) {
                    qu.add(node.right);
                }
            }

            pq.add(sum);
        }

        if (k > pq.size()) {
            return -1;
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        return pq.poll();
    }
}