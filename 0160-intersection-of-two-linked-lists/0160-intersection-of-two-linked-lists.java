/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ac = 0, bc = 0;
        ListNode A = headA;
        ListNode B = headB;

        while (A.next != null) {
            A = A.next;
            ac++;
        }

        while (B.next != null) {
            B = B.next;
            bc++;
        }

        while (ac < bc) {
            headB = headB.next;
            bc--;
        }

        while (bc < ac) {
            headA = headA.next;
            ac--;
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}