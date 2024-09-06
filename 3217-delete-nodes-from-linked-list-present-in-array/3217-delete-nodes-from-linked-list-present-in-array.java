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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        ListNode ans = head;
        ListNode prev = head;

        head = head.next;

        while (head != null) {
            if (set.contains(head.val)) {
                if (head.next == null) {
                    prev.next = null;
                }

                head = head.next;                
                continue;
            }

            prev.next = head;
            prev = prev.next;
            head = head.next;
        }

        

        return ans;
    }
}