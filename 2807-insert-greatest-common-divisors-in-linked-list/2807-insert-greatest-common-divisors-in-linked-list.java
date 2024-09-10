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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode hare = head.next;
        ListNode tortoise = head;

        while (hare != null) {
            int cd = findGreatestCommonDivisor(hare.val, tortoise.val);

            tortoise.next = new ListNode(cd);
            tortoise.next.next = hare;

            tortoise = tortoise.next.next;
            hare = hare.next;
        }

        return head;
    }

    private int findGreatestCommonDivisor(int a, int b) {
        int divisor = 1;

        int n = Math.min(a, b);

        for (int i = 2; i <= n; i++) {
            if (a % i == 0 && b % i == 0) {
                divisor = i;
            }
        }

        return divisor;
    }
}