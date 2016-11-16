/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * Example:
 *   Given 1->2->3->4->5->NULL,
 *   return 1->3->5->2->4->NULL.
 * 
 * There are two solutions.
 */
 
// Sol1, Return: Your runtime beats 2.50% of java submissions
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode newHead1  = new ListNode(head.val);
        ListNode newHead2  = new ListNode(head.next.val);
        ListNode oddHead  = newHead1;
        ListNode evenHead = newHead2;
        ListNode node = head.next.next;
        boolean odd = true;
        while(node != null) {
            if(odd) {
                oddHead.next = new ListNode(node.val);
                oddHead = oddHead.next;
            } else {
                evenHead.next = new ListNode(node.val);
                evenHead = evenHead.next;
            }
            odd = !odd;
            node = node.next;
        }
        
        oddHead.next = newHead2;
        
        return newHead1;
    }
}
 
 
// Simple O(N) time, O(1), space Java solution.
// Sol2, Return: Your runtime beats 71.50% of java submissions
public class Solution {
public ListNode oddEvenList(ListNode head) {
    if (head != null) {
    
        ListNode odd = head, even = head.next, evenHead = even; 
    
        while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead; 
    }
    return head;
}}

 
