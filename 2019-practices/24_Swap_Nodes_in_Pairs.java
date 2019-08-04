/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while( cur != null && cur.next != null ) {
            
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;

            if(prev != null) prev.next = next;
            else newHead = next;
            
            prev = cur;
            cur = cur.next;
        }
        return newHead != null ? newHead : head;
    }
}
