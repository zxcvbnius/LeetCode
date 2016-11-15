/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * Result. "Your runtime beats 27.63% of java submissions :("
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null && l2!=null) return l2;
        else if(l1!=null && l2==null) return l1;
        else if(l1==null && l2==null) return null;
        
        ListNode node1 = l1;
        ListNode node2 = l2;
        
        ListNode res   = null;
        ListNode cur   = null;
        
        while( node1 != null || node2 != null) {
            ListNode node = null;
            if(node1 == null && node2 != null) {
                node  = new ListNode(node2.val);
                node2 = node2.next;
            } else if(node1 != null && node2 == null) {
                node  = new ListNode(node1.val);
                node1 = node1.next; 
            } else {
                if(node1.val < node2.val) {
                    node  = new ListNode(node1.val);
                    node1 = node1.next;
                } else {
                    node  = new ListNode(node2.val);
                    node2 = node2.next;
                }
            }
            
            if(res == null) {
                res = node;
                cur = node;
            } else if(res.next == null) {
                cur.next = node;
                cur  = cur.next;
                res.next = cur;
            } else {
                cur.next = node;
                cur  = cur.next;
            }
        }
        
        return res;
    }
}

// Improving: merging two linked list without generating new object
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode head1=null;
      ListNode head2=null;
      if(l1==null && l2!=null)
          return l2;
      else if(l1!=null && l2==null)
          return l1;
      else if(l1==null && l2==null)
          return l1;

      if(l1.val<l2.val){
         head1= l1;
         head2=l2;
    }else{
         head2=l1;
         head1=l2;
    }

    ListNode root = head1;

    while(head2!=null){
      while((head1!=null && head1.val < head2.val) && 
                 (head1.next!=null && head1.next.val<head2.val)){
        head1=head1.next;
      }

      ListNode p2 = head2.next;

      head2.next=head1.next;
      head1.next=head2;
      head1=head1.next;
      head2=p2;

    }
    return root;
  }
}
