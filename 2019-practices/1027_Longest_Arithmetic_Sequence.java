class Solution {
    public int longestArithSeqLength(int[] A) {

        int ans = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[ A.length ];
        for(int i = 0 ; i < A.length ; i++) dp[i] = new HashMap<>();
        
        for(int i = 0 ; i < A.length ; i++) {
            for(int j = i + 1 ; j < A.length ; j++) {
                int val = A[i] - A[j];

                Integer count = dp[i].get( val );
                
                if(count == null) count = 1;
                else count++;

                dp[j].put( val, count );
                ans = Math.max( ans,  count );
            }
        }
        return ans + 1;
    }
}
