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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> sumNodeMap = new HashMap<>();
        
        ListNode dummyPreHead = new ListNode(0);
        dummyPreHead.next = head;
        
        sumNodeMap.put(0, dummyPreHead);      

        ListNode currNode = head;
        int sum = 0;
        
        while(currNode != null) {
            sum += currNode.val;
            
            if (sumNodeMap.containsKey(sum)) { 
                ListNode oldNodeWithSameSum = sumNodeMap.get(sum);          
                ListNode toBeRemovedNode = oldNodeWithSameSum.next;        
                int toBeRemovedSum = sum;

                while (toBeRemovedNode != currNode) {
                    toBeRemovedSum = toBeRemovedSum + toBeRemovedNode.val;
                    sumNodeMap.remove(toBeRemovedSum);
                    toBeRemovedNode = toBeRemovedNode.next;
                }

                oldNodeWithSameSum.next = currNode.next;              
            }
            
            else {
                sumNodeMap.put(sum, currNode);
            }
            
            currNode = currNode.next;
        }
        
        return dummyPreHead.next;
    }
}