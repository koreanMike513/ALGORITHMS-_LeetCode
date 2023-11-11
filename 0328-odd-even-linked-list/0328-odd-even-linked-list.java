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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode ans = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode curEven = even;

        while (odd != null && odd.next != null && curEven != null && curEven.next != null) {
            odd.next = odd.next.next;
            curEven.next = curEven.next.next;
            
            odd = odd.next; 
            curEven = curEven.next;
        }

        odd.next = even;

        return ans;
    }
}