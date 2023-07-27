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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode current = slow.next;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }


        slow.next = null;

        fast = head;
        slow = prev;

        while (fast != null && slow != null) {    
            ListNode temp1 = fast.next;
            fast.next = slow;

            ListNode temp2 = slow.next;
            slow.next = temp1;

            fast = temp1;
            slow = temp2;
        }
    }
}