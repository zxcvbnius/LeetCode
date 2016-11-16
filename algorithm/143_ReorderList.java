/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 *   For example,
 *      Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Result. "Your runtime beats 10.39% of java submissions :("
 */
 
 
 
// 1) Using walker and runner to find middle-node 
// 2) Reverse the linked list from middle-node to end 
// 3) merge two linkedlist
public class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null) return;
        
        ListNode walker = head;
        ListNode runner = head.next;
        
        boolean odd = true;
        
        while(runner != null && walker != null) {
            walker = walker.next;
            if(runner.next == null) {
                runner = null;
                odd    = false;
            }
            else runner = runner.next.next;
        }
        
        if(walker!= null && walker.next != null) {
            walker = reverse(walker.next); // reverse linkedlist
            ListNode node = head;
            while(walker != null) {
                // System.out.println("n: " + node.val + ",w: " + walker.val);
                ListNode temp = node.next;
                node.next = new ListNode(walker.val);
                node.next.next = temp;
                walker = walker.next;
                node   = temp;
                if(walker == null) {
                    if(odd) node.next = null;
                    else node.next.next = null;
                    break;
                }
            }
        }
    }
    
    
    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead   = head;
            head = next;
        }
        return newHead;
    }
    
}
