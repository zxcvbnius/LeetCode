class Solution {
    public int getMoneyAmount(int n) {
        int[][] ans = new int[ n+1 ][ n+1 ];
        helper(ans, 1, n);
        return ans[1][n];
    }
    
    public int helper(int[][] ans, int s, int e) {
        if( s >= e || ans[s][e] != 0 ) return ans[s][e];
        int res = Integer.MAX_VALUE;
        for(int i = s ; i < e ; i++) {
            int tmp = i + Math.max( helper(ans, s, i - 1), helper(ans, i + 1, e) );
            res = Math.min( res, tmp );
        }
        ans[s][e] = res;
        return res;
    }
}
