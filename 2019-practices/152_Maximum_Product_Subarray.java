class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = Integer.MIN_VALUE;
        
        int[][] dp = new int[ nums.length ][2]; // 0: max, 1: min
        dp[0][0] = dp[0][0] = nums[0];
        
        int ans = nums[0];
        
        for(int i = 1 ; i < nums.length ; i++) {
            dp[i][0] = Math.max( dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]);
            if(dp[i][0] < nums[i]) dp[i][0] = nums[i];
            dp[i][1] = Math.min( dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]);
            if(dp[i][1] > nums[i]) dp[i][1] = nums[i];
            
            ans = Math.max( ans , dp[i][0] );
        }
        return ans;
    }
}
