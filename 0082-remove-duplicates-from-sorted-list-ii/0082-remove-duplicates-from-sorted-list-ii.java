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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode before = head;
        ListNode start = new ListNode();
        ListNode after = start;

        while (before != null) {
            int count = 0;
            int temp = before.val;
            
            while (before != null && temp == before.val) {
                before = before.next;
                count++;
            }

            if (count == 1) { 
                after.next = new ListNode(temp); 
                after = after.next;
            }

            count = 0;
        }

        return start.next;
    }
}