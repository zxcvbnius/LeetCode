/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * Result. "Your runtime beats 86.35 % of java submissions."
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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0) return null;
        
        int count = 0, n = lists.length;
        while( n > 0) {
            count++;
            n /= 2;
        }
        
        int curLen = 2, len = lists.length;
        while( count > 0) {
            for(int i = 0 ; i * curLen < lists.length ; i++) {
                int start = i * curLen;
                int end = i * curLen + curLen / 2;
                // System.out.println("curLen" + curLen + ", start : " + start + ", end : " + end);
                lists[start] = mergeTwoLists(lists[start], (end >= lists.length) ? null : lists[end] );
            }
            curLen *= 2;
            count--;
        }
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode list = null;
        if(list1.val < list2.val) {
            list = list1;
            list1 = list1.next;
        } else {
            list = list2;
            list2 = list2.next;
        }
        
        ListNode temp = list;
        while(list1 != null || list2 != null) {
            if(list1 == null) {
                temp.next = list2;
                return list;
            } else if(list2 == null) {
                temp.next = list1;
                return list;
            } else {
                if(list1.val < list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                    temp = temp.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                    temp = temp.next;
                }
            }
        }
        return list;
    }
}
