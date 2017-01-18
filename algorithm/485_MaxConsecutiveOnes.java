/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * 
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * Result: Result. "Your runtime beats 79.42% of java submissions." 
 **/
 
 public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int max = 0, curCount = 0;
        for(int i = 0 ; i < len ; i++) {
            if(nums[i] == 0) {
                if(curCount > max) max = curCount;
                curCount = 0;
            } else {
                curCount++;
            }
        }
        if(curCount > max) max = curCount;
        return max;
    }
}
 
 
