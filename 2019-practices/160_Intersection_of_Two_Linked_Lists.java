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
        int aLen = getLen(headA);
        int bLen = getLen(headB);

        while( aLen > bLen ) {
            headA = headA.next;
            aLen--;
        }
        
        while( bLen > aLen ) {
            headB = headB.next;
            bLen--;
        }
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    public int getLen(ListNode node) {
        int count = 0 ;
        while(node != null ) {
            count++;
            node = node.next;
        }
        return count;
    }
}
