/**
 * You are given two linked lists representing two non-negative numbers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Result. "Your runtime beats  45.95%v76.91% of java submissions"
 */
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Space Complexity: O(1)
 class LenListNode {
     int len;
     ListNode node;
     LenListNode(ListNode n, int l) { node = n; len = l; }
 }
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return l2;
        if(l1 == null ) return l2;
        if(l2 == null ) return l1;
        
        // reverse l1
        LenListNode lenNode1 = reverse(l1);
        l1 = lenNode1.node;
        
        // reverse l2
        LenListNode lenNode2 = reverse(l2);
        l2 = lenNode2.node;
        
        // merge l1 into l2
        ListNode mergeNode = (lenNode1.len > lenNode2.len) ? merge2List(l1, l2) : merge2List(l2, l1);
        
        // return new mergeNode
        return reverse(mergeNode).node;
    }
    
    public LenListNode reverse(ListNode root) {
        ListNode newHead = null;
        int len = 0;
        while(root != null) {
            ListNode temp = root.next;
            root.next = newHead;
            newHead   = root;
            root      = temp;
            len++;
        }
        LenListNode n = new LenListNode(newHead, len);
        return n;
    }
    
    public ListNode merge2List(ListNode lNode, ListNode sNode) { // lNode has more lengths than sNode
        
        ListNode newHead = lNode;
        boolean addOne = false;
        ListNode preNext  = null;
        
        while(lNode != null) {
            
          if(lNode.next == null) preNext = lNode;
          
          if(sNode == null) {
            lNode.val += (addOne) ? 1 : 0;
            if(lNode.val >= 10) {
                lNode.val = 0;
                addOne = true;
            } else {
                addOne = false;
            }
            lNode = lNode.next;    
          } else {
              lNode.val = sNode.val + lNode.val + (addOne ? 1 : 0);             
              if(lNode.val >= 10) {
                  lNode.val = lNode.val % 10;
                  addOne = true;
              } else {
                  addOne = false;
              }
              sNode = sNode.next;
              lNode = lNode.next;
          }
        
        }
        
        if(addOne) preNext.next = new ListNode(1);
            
        return newHead;            
    }
}
