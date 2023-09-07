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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;
        if (lists.length == 1) return lists[0];
        
        ListNode ans = merge(lists[0], lists[1]);
        int i = 2;

        while (i < lists.length) {
            ans = merge(ans, lists[i++]);
        }

        return ans;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode c = new ListNode(0);
        ListNode rc = c;

        while (a != null || b != null) {
            int valA = (a != null) ? a.val : 10001;
            int valB = (b != null) ? b.val : 10001;

            if (valA < valB) {
                c.next = new ListNode(valA);

                a = a.next;
                c = c.next;
            }
            else {
                c.next = new ListNode(valB);

                b = b.next;
                c = c.next;
            }
        }

        return rc.next;
    }
}