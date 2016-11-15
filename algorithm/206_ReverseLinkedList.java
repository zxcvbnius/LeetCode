/**
 * Reverse a singly linked list.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 
 // Sol1: Result. "Your runtime beats 4.96% of java submissions :("
 public class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null) return null;
        
        ArrayList<ListNode> res = new ArrayList<>();
        
        ListNode node = head;
        while(node != null) {
            ListNode n = new ListNode(node.val);
            res.add(n);
            node = node.next;
        }
        
        int len = res.size();
        ListNode head1 = res.get(len - 1);
        for(int i = len - 2 ; i >= 0 ; i--) {
            head1.next = res.get(i);
            head1 = head1.next;
        }
        
        return res.get(len - 1);
        
    }
}


// So2: Result. "Your runtime beats 32.36% of java submissions :("
public class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
