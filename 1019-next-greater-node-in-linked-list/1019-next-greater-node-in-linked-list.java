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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        int length = 0, i = 0;

        ListNode temp = head;

        while (temp != null) { 
            temp = temp.next;
            length++; 
        }

        int[] ans = new int[length];
        int[] list = new int[length];

        while (head != null) {
            while (!st.isEmpty() && list[st.peek()] < head.val) {
                ans[st.pop()] = head.val;
            }
            
            st.push(i);
            list[i++] = head.val;
            head = head.next;
        }

        return ans;
    }
}