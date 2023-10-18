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
    int moves = 0;
    
    public int distributeCoins(TreeNode root) {
        postOrderTraversal(root, null);
        return moves;
    }
    
    public void postOrderTraversal(TreeNode curr, TreeNode parent){
        if(curr == null) return;
     
        postOrderTraversal(curr.left, curr);
        postOrderTraversal(curr.right, curr);
        
        if (curr.val < 1) {
            moves += (1 - curr.val);
            parent.val -= (1 - curr.val); 
        }

        else if (curr.val > 1) {
            moves += curr.val - 1;
            parent.val += curr.val - 1;
        }
        
    }
}