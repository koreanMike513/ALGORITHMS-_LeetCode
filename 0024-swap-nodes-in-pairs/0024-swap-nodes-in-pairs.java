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
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) return head;

        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        fast = fast.next.next;
        slow = slow.next;

        dummy.next = new ListNode(fast.val);
        dummy = dummy.next;
        dummy.next = new ListNode(slow.val);
        dummy = dummy.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next.next;

            if (fast == null) {
                dummy.next = new ListNode(slow.val);
                return ans.next;
            }

            dummy.next = new ListNode(fast.val);
            dummy = dummy.next;
            dummy.next = new ListNode(slow.val);
            dummy = dummy.next;
        }

        return ans.next;
    }
}