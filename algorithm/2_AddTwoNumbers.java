/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 *  
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
 
 
 // Sol1, Result. "Your runtime beats  4.40% of java submissions :/"
 public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head1 = l1;
        ListNode head2 = l2;
        int len1 = 0;
        int len2 = 0;
        
        while( l1 != null && l2 != null ) {
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null) len1 = 1;
        if(l2 != null) len2 = 1;
        
        return len1 > len2 ? mergeListNode(head1, head2) : mergeListNode(head2, head1);
    }
    
    public ListNode mergeListNode(ListNode lNode, ListNode sNode) {
        
        boolean addOne = false;
        ListNode preNode = null;
        ListNode head = lNode;
        while(lNode != null) {
            if(lNode.next == null) preNode = lNode;
            if(sNode == null) {
                lNode.val += (addOne) ? 1 : 0 ;
                if(lNode.val >= 10) {
                    lNode.val = 0;
                    addOne = true;
                } else {
                    addOne = false;
                }
                lNode = lNode.next;
            } else {
                lNode.val = lNode.val + sNode.val + (addOne ? 1 : 0);
                if(lNode.val >= 10) {
                    lNode.val -= 10;
                    addOne = true;
                } else {
                    addOne = false;
                }
                lNode = lNode.next;
                sNode = sNode.next;
            }
        }
        if(addOne) preNode.next = new ListNode(1);
        
        return head;
    }
}


// Result. "Your runtime beats  20.38% of java submissions"
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}
