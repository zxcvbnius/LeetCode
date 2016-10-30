/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, 
 * with the first five elements of nums being 1, 1, 2, 2 and 3. 
 * It doesn't matter what you leave beyond the new length.
 * Result. "Your runtime beats 32.67% of java submissions :("
 */
 public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int count = 1;
        int cur   = nums[0];
        int curCount = 1;
        for(int i = 1 ; i < len; i++) {
            if(nums[i] != cur) {
                curCount = 0;
                cur = nums[i];
            }
            if(curCount < 2) {
                nums[count] = nums[i];
                curCount++;
                count++;
            }
        }
        return count;
    }
}
