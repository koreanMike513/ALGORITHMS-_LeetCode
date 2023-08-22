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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left <= 0 || right <= 0 || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) { prev = prev.next; }

        ListNode rh = null;
        ListNode current = prev.next;
        
        for (int j = 0; j <= right - left; j++) {
            ListNode temp = current.next;
            current.next = rh;
            rh = current;
            current = temp;
        }

        prev.next.next = current;
        prev.next = rh;

        return dummy.next;
    }
}