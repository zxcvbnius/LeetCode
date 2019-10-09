/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = reverse(l1);
        ListNode n2 = reverse(l2);

        ListNode dumy = new ListNode(-1);
        ListNode node = dumy;
        
        boolean plusOne = false;
        while( n1 != null && n2 != null ) {
            int val = n1.val + n2.val + (plusOne? 1 : 0);
            
            if(val >= 10 ) plusOne = true;
            else plusOne = false;
            
            node.next = new ListNode(val % 10);
            node = node.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        
        while( n1 != null) {
            int val = n1.val + (plusOne? 1 : 0);
            if(val >= 10 ) plusOne = true;
            else plusOne = false;
            
            node.next = new ListNode( val % 10); 
            node = node.next;
            n1 = n1.next;
        }
        
        while( n2 != null) {
            int val = n2.val + (plusOne? 1 : 0);
            
            if(val >= 10 ) plusOne = true;
            else plusOne = false;
            node.next = new ListNode( val % 10); 
            node = node.next;
            n2 = n2.next;
        }
        
        if(plusOne) {
            node.next = new ListNode(1);
        }
        return reverse(dumy.next);
    }
    
    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        while( node != null ) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
        
    }
}
