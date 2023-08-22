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
        ListNode list = ans;
        ListNode prev1 = null;

        while (l1 != null) {
            ListNode temp = l1.next;
            l1.next = prev1;
            prev1 = l1;
            l1 = temp;
        }

        ListNode prev2 = null;

        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = prev2;
            prev2 = l2;
            l2 = temp;
        }

        int carry = 0;

        while (prev1 != null || prev2 != null || carry != 0) {
            int val1 = (prev1 != null) ? prev1.val : 0;
            int val2 = (prev2 != null) ? prev2.val : 0;

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            list.next = new ListNode(sum);

            list = list.next;
            prev1 = (prev1 != null) ? prev1.next : null;
            prev2 = (prev2 != null) ? prev2.next : null;
        }

        ListNode prev3 = null;
        ans = ans.next;

        while (ans != null) {
            ListNode temp = ans.next;
            ans.next = prev3;
            prev3 = ans;
            ans = temp;
        }

        return prev3;
    }
}