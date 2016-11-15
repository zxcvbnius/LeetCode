/**
 * Given a linked list, determine if it has a cycle in it.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Result. "Your runtime beats 9.80% of java submissions :("
 * Using Floyd Algorithm.
 */
 
 /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode tortoise = head;
        ListNode hare     = head.next;
    
        while(tortoise != null && hare != null && tortoise.val != hare.val) {
            tortoise = tortoise.next;
            if(hare.next != null) hare = hare.next.next;
            else return false;
        }
        
        if(tortoise == null || hare == null) return false;
        
        return true;
    }
}
