class Solution {
    public double new21Game(int N, int K, int W) {
        // dp(i): (dp[1] + dp[2] + ... + dp[i-1]) / W
        if( K == 0 || N > K + W ) return 1.0;

        double[] dp = new double[ N + 1 ];
        double sum = 1.0;
        double res = 0.0;
        dp[0] = 1; // same as sum init value

        for(int i = 1 ; i <= N ; i++) {
          dp[i] = sum / W;

          if( i < K ) sum += dp[i];
          else res += dp[i];

          if( i - W >= 0 ) {
              sum -= dp[ i - W ];
          }
        }
        return res;
    }
}
