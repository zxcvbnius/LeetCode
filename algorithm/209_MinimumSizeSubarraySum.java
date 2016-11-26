/**
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * Result. "Your runtime beats 12.54% of java submissions." (Most ppl in the range)
 */
 public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int minLen = Integer.MAX_VALUE;
        int curSum = 0, index = 0, from = 0;
        
        while(from < nums.length && index < nums.length) {
            
            while(curSum < s && index < nums.length) {
                curSum += nums[index];
                if(curSum >= s) {
                    int count = index - from + 1;
                    if(minLen > count ) minLen = count;
                    break;
                }
                index++;
            } 
            if(index < nums.length) {
                curSum -= nums[from];
                curSum -= nums[index];
                from++;                
            }
        }
        
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
        
    }
    
}
 
