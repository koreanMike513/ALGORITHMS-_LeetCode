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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        ListNode ans = new ListNode(0);
        ListNode node = ans;
        int carry = 0;

        while (carry != 0 || l1 != null || l2 != null) {
            int val1 = (l1 != null ? l1.val : 0);
            int val2 = (l2 != null ? l2.val : 0);

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            node.next = new ListNode(sum);
            node = node.next;

            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }

        return ans.next;
    }
}