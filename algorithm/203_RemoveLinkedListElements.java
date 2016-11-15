/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * Result. "Your runtime beats 6.13% of java submissions."
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode preNode = null;
        while(node != null) {
          if(node.val == val) {
              if(preNode == null) {
                  head = node.next;
                  node = node.next;
              } else {
                  preNode.next = node.next;
                  node = node.next;
              }
          } else {
            preNode = node;
            node = node.next;                  
          }
        }
        
        return head;
    }
}
