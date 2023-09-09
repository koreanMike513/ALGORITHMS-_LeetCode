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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode isK = head;

        for (int i = 0; i < k; i++) {
            if (isK == null) {
                return head;
            }

            isK = isK.next;
        }

        ListNode start = head;
        ListNode prev = null;

        int count = 0;

        while (head != null && count < k) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            count++;
        }

        start.next = reverseKGroup(head, k);

        return prev;
    }
}