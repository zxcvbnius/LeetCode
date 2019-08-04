/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null) return null;
        
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            size++;
        }
        int[] nums = new int[size];
        
        cur = head;
        int idx = 0;
        while(cur != null) {
            nums[idx++] = cur.val;
            cur = cur.next;
        }
        
        quicksort(nums, 0, nums.length - 1);
        ListNode newHead = new ListNode( nums[0] );
        cur = newHead;
        for(int num : nums) {
            cur.next = new ListNode( num );
            cur = cur.next;
        }
        
        return newHead.next;
        
    }
    public void quicksort(int[] nums, int lo, int hi) {
        int i = lo, j = hi, pivot = nums[ (lo + hi) / 2 ];
        
        while(i <= j) {
            while( nums[i] < pivot) i++;
            while( nums[j] > pivot) j--;
            
            if(i<=j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        if(i < hi) quicksort(nums, i, hi);
        if(j > lo) quicksort(nums, lo, j);
    }
}
