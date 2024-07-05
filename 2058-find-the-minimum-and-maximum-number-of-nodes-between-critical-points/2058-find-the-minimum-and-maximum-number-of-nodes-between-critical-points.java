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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        List<Integer> list = new ArrayList<>();

        int left = head.val;
        head = head.next;  
        int center = head.val;
        head = head.next;
        int index = 2;
        
        while (head != null) {
            int right = head.val;

            if ((center > left && center > right) || (center < left && center < right))
                list.add(index);

            head = head.next;
            left = center;
            center = right;
            index++;
        }

        int min = Integer.MAX_VALUE, max = -1, n = list.size() - 1;

        if (list.size() > 1) {
            max = list.get(n) - list.get(0);
            
            for (int i = 0; i < n; i++) {
                int sub = list.get(i + 1) - list.get(i);

                if (sub < min) 
                    min = sub;
            }
        }

        ans[0] = (min == Integer.MAX_VALUE) ? -1 : min;
        ans[1] = max;

        return ans;
    }
}