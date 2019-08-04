/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        return partion( lists, 0, lists.length - 1);
    }
    
    public ListNode partion(ListNode[] lists,int s,int e) {
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return mergeTwoLists(l1,l2);
        }else
            return null;
    }
    
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        ListNode head = null;
        
        if(node1.val <= node2.val) {
            head = node1;
            node1 = node1.next;
        } else {
            head = node2;
            node2 = node2.next;
        }
        
        ListNode cur = head;
        
        
        while(node1 != null && node2 != null) {
            if( node1.val <= node2.val ) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        
        if(node1 != null) cur.next = node1;
        if(node2 != null) cur.next = node2;

        return head;
    }
}
