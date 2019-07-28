/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode dummyHead = new ListNode(-1);
        ListNode curNode = dummyHead;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            
            curNode = curNode.next;
        }
        
        if(l1 != null) curNode.next = l1;
        if(l2 != null) curNode.next = l2;
             
        return dummyHead.next;
    }
}
