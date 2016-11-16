/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 * Result. "Your runtime beats 6.64% of java submissions :("
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null) return true;
        
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        
        int len = list.size();
        int start = len / 2 + ((len % 2 == 0 ) ? 0 : 1);
        int index = len / 2 - 1; 
        for(int i = start ; i < len ; i++) {
            if( (int)list.get(index) != (int)list.get(i) ) return false;
            index--;
        }
        return true;
        
    }
}
