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
        ListNode ans = new ListNode(0), t = ans;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ListNode list : lists) {
            while (list != null) {
                pq.add(list.val);
                list = list.next;
            }
        }

        while (!pq.isEmpty()) {
            t.next = new ListNode(pq.poll());
            t = t.next;
        }

        return ans.next;
    }
}