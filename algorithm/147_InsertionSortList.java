/**
 * Sort a linked list using insertion sort.
 * Result. "Your runtime beats 97.51% of java submissions/"
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
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null) return null;
        
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        
        int[] array = new int[ list.size() ];
        for(int i = 0 ; i < array.length; i++) {
            array[i] = list.get(i);
        }
        
        Arrays.sort(array);
        
        ListNode newHead = new ListNode(array[0]);
        ListNode temp = newHead;
        for(int i = 1 ; i < array.length; i++) {
            ListNode next = new ListNode(array[i]);
            temp.next = next;
            temp = temp.next;
        }
        
        return newHead;
        
    }
}
