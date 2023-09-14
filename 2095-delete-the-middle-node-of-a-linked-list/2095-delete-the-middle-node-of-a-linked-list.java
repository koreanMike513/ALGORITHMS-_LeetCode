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
    public ListNode deleteMiddle(ListNode head) {
        ListNode ans = new ListNode(0);
        ans.next = head;

        ListNode hare = head;
        ListNode tortoise = ans;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }        

        tortoise.next = tortoise.next.next;

        return ans.next;
    }
}