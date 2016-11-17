/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 *    Given 1->2->3->4->5->NULL, m = 2 and n = 5,
 *    return 1->5->4->3->2->NULL.
 * Result. "Your runtime beats 14.55% of java submissions :("
 */


// Step1, find (m-1), (m) , (n), (n+1) nodes
// Step2, reverse [m, n] nodes
// Step3, assign the next of (m-1) nodes to newHead
// Step4, assign the next of the end of newHead to (n+1) node

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head == null) return null;
        
        ListNode pre = null, start = null, to = null, end = null, node = head;
        int count = 1;
        while(node != null) {
            if(count == m-1) pre    = node;
            if(count == m)   start  = node;
            if(count == n)   to     = node;
            if(count == n+1) end    = node;
            count++;
            node = node.next;
        }
        
        ListNode newHead = reverse(pre, start , to, end);
        return (pre == null) ? newHead : head;
    }
    
    public ListNode reverse(ListNode pre, ListNode start, ListNode to, ListNode end) { // exculsive start-node and end-node
    
         ListNode newHead = null;
         ListNode sTemp   = start;
         while(start != end) {
             ListNode temp  = start.next;
             start.next = newHead;
             newHead    = start;
             start      = temp;
         }
         if(pre != null) pre.next = newHead;
         sTemp.next = end;
         
         return newHead;
    }
}
