/**
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Result. "Your runtime beats 79.65% of java submissions"
 */
public class Solution {
  public int removeDuplicates(int[] nums) {
    int i = nums.length > 0 ? 1 : 0;
    for (int n : nums)
        if (n > nums[i-1])
            nums[i++] = n;
    return i;
  }
}
