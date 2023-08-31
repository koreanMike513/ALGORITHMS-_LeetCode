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
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        int carry = 0;

        while (prev != null || carry != 0) {
            int value = ((prev != null) ? prev.val * 2 : 0) + carry;
            carry = value / 10;

            stack.push(value % 10);
            prev = (prev == null) ? null : prev.next;
        }

        ListNode ans = new ListNode(0);
        ListNode temp = ans;  

        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }

        return ans.next;
    }
}