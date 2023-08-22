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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (dummy != null) {
            while (!stack.isEmpty() && dummy.val > stack.peek()) {
                stack.pop();
            }

            stack.push(dummy.val);
            dummy = dummy.next;
        }

        ListNode ans = new ListNode(0);
        ListNode t = ans;

        for (int num: stack) { 
            t.next = new ListNode(num);
            t = t.next;
        }

        return ans.next;
    }
}