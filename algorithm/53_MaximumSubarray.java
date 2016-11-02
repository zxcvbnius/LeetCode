/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * Result. "Your runtime beats 56.67% of java submissions."
 */
 
 // Using dynamic programming
public class Solution {
    public int maxSubArray(int[] nums) {
        int len  = nums.length; 
        
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        
        int[] dp = new int[len];
        dp[0]    = nums[0];
        int max  = dp[0];
        
        for(int i = 1 ; i < len ; i++ ) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            if(max < dp[i]) max = dp[i];
        }
        
        return max;
    }
}
