/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Result. "Your runtime beats 82.39% of java submissions."
 */
 
 // Using mergeSort to solve this problem
 
 public class Solution {
    
    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null ) return head;
        
        // Using slow-fast
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return mergeSort(l1, l2);   
    }
    
    private ListNode mergeSort(ListNode head1, ListNode head2) {
        
        ListNode head = null, temp = null;
        
        if(head1 == null) return head2;
        else if(head2 == null) return head1; 
        else {
            if(head1.val < head2.val) {
                head  = head1;
                head1 = head1.next;
            } else {
                head  = head2;
                head2 = head2.next;
            }
            temp = head;
            while(head1 != null || head2 != null) {
                if(head1 == null) {
                    head.next = head2;
                    return temp;
                } else if(head2 == null) {
                    head.next = head1;
                    return temp;
                } else {
                    if(head1.val < head2.val) {
                        head.next = head1;
                        head1 = head1.next;
                        head = head.next;
                    } else {
                        head.next = head2;
                        head2 = head2.next;
                        head = head.next;
                    }
                }
            }
        }
        return temp;
    }
    
}
