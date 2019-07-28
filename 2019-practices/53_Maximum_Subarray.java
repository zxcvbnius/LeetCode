class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        int[] dp = new int[len];
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < len ; i++) {
            if(i == 0) {
                dp[0] = nums[0];
            } else {
                dp[i] = Math.max( dp[i-1] + nums[i], nums[i]);
            }
            if(maxSum < dp[i]) maxSum = dp[i];
        }
        
        return maxSum;
    }
}
