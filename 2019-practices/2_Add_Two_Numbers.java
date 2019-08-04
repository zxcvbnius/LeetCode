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
        //l1 = reverseList(l1);
        //l2 = reverseList(l2);
        
        ListNode res = null, head = null;
        int plusOne = 0;
        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + plusOne;
            plusOne = val / 10;
            val = val % 10;
            
            if(res == null) {
                res = new ListNode(val);
                head = res;
            } else {
                res.next = new ListNode(val);
                res = res.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while( l1 != null) {
            int val = l1.val + plusOne;
            plusOne = val / 10;
            val = val % 10;
            
            res.next = new ListNode(val);
            res = res.next;
            l1 = l1.next;
        }
        
        while( l2 != null) {
            int val = l2.val + plusOne;
            plusOne = val / 10;
            val = val % 10;

            res.next = new ListNode(val);
            res = res.next;
            l2 = l2.next;
        }
        
        if(plusOne == 1) res.next = new ListNode(1);
        
        return head;
    }
}
