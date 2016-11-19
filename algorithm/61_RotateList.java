/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 *   Given 1->2->3->4->5->NULL and k = 2,
 *   return 4->5->1->2->3->NULL.
 * Result. "Your runtime beats 21.67% of java submissions"
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;

        /* find the end of list */
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        /* form a circle */
        tail.next = head;
        k = k % len;
        for (int i = 0; i < len - k; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}
