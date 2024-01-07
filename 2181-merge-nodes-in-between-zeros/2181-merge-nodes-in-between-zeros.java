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
    public ListNode mergeNodes(ListNode head) {
        if (head == null) return null;

        ListNode ans = new ListNode();
        ListNode t = ans;

        head = head.next;
        
        while (head != null) {
            int sum = 0;

            while (head.val != 0) {
                sum += head.val;
                head = head.next;
            }

            t.next = new ListNode(sum);
            t = t.next;
            head = head.next;
        }

        return ans.next;
    }
}