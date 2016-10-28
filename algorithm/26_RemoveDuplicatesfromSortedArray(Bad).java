/**
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Result. "Your runtime beats 20.65% of java submissions :("
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
     int len   = nums.length;
     int count = 0;
     if(len > 0) {
         count = 1;
         int current = nums[0];
         if(len == 1) return count;
         for(int i = 1 ; i < len; i++) {
             int val = nums[i];
             if(current < val) {
                 nums[count] = val;
                 current     = val;
                 count++;
             }
         }
     }
     return count;
    }
}
