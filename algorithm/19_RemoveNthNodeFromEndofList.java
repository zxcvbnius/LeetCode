/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Result. "Your runtime beats 38.60% of java submissions :("
 */
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 class BiListNode {
	ListNode node;
	ListNode preNode;
	BiListNode(ListNode node, ListNode preNode) {
		this.node = node;
		this.preNode = preNode;
	}
}
 
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
		BiListNode[] nodes = new BiListNode[n];
        
		int curIndex     = -1;
        int length       = 0;
        ListNode preNode = null;
        while(node != null) {
        	
            curIndex++;
            if(curIndex >= n) curIndex = 0;
            	
            nodes[curIndex] = new BiListNode(node, preNode);
            
            length++;
            preNode = node;
            node    = node.next;
        }
        
        if(length < n) return head.next;
        
        curIndex = length % n;
        
        ListNode pre  = nodes[curIndex].preNode;
        ListNode next = nodes[curIndex].node.next;
        
        
        if(pre == null && next == null) return null;
        else if(pre == null) return head.next;
        else if(next == null) {
        	pre.next = null;
        } else {
        	pre.next = next;
        }
        return head;
    }
}
