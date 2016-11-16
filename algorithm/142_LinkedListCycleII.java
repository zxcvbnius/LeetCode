/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up:
 *   Can you solve it without using extra space?
 * Result. "Your runtime beats 18.82% of java submissions :("
 * Using Floy'd Algorithm.
 *
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
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        
        ListNode walker = head;
        ListNode runner = head.next;
        
        // 1. check if the linkedlist  has a cycle
        while(runner != null && walker != null && runner.val != walker.val) {
            walker = walker.next;
            if(runner.next != null) runner = runner.next.next;
            else runner = null;
        }
        if(runner == null || walker == null) return null;
        
        // 2. walker go back to head and find the start-node of the cycle
        walker = head;
        runner = runner.next;
        while(walker.val != runner.val) {
            walker = walker.next;
            runner = runner.next;
        }
        return runner;
        
    }
}
