/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode reversedHead = reverseList(head);
        ListNode cur = reversedHead;
        int addOne = 1;
        while(cur != null) {
            int val = cur.val + addOne;
            addOne = val / 10;
            val = val % 10;
            
            cur.val = val;
            cur = cur.next;
            
            if(addOne == 0) break;
        }
        
        ListNode result = reverseList(reversedHead);
        
        if(addOne == 1) {
            ListNode node = new ListNode(1);
            node.next = result;
            return node;
        }
        
        return result;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
