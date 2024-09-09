/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int start = 0;

        for (int[] mx : matrix) {
            Arrays.fill(mx, -1);
        }

        while (start < n && start < m && head != null) {   
            for (int i = start; i < n - start && head != null ; i++) {
                matrix[start][i] = head.val;
                head = head.next;
            }

            for (int i = start + 1; i < m - start && head != null ; i++) {
                matrix[i][n - start - 1] = head.val;
                head = head.next;
            }

            for (int i = n - start - 2; i >= start && head != null ; i--) {
                matrix[m - start - 1][i] = head.val;
                head = head.next;
            }

            for (int i = m - start - 2; i > start && head != null ; i--) {
                matrix[i][start] = head.val;
                head = head.next;
            }

            start++;
        }

        return matrix;
    }
}