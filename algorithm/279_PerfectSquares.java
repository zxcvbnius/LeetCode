/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) 
 * which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * 
 * Result. "Your runtime beats 62.93% of java submissions."
 */
 
 // Sol.
 // dp[0] = 0
 // dp[1] = 1
 // dp[2] = 2 
 // dp[3] = 3  
 // dp[4] = Math.min( dp[4 - 1*1 ] + 1, dp[4 - 2*2 ] + 1)
 // ....
 
 public class Solution {
    public int numSquares(int n) {
        
        int[] dp = new int[n + 1];
        for(int i = 0 ; i <= n ; i++) dp[i] = Integer.MAX_VALUE;
        
        if(n <= 3) return n;
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for(int i = 4 ; i <= n ; i++ ) {
            int index = 1;
            int val   = i - index * index;
            while( val >= 0) {
                dp[i] = Math.min( dp[i], dp[val] + 1 );
                index++;
                val   = i - index * index;
            }
        }
        
        return dp[n];
    }
}
