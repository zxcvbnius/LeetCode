class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort( A );
        
        int max = -1;
        
        int lo = 0, hi = A.length - 1;
        while( lo < hi ) {
            int sum = A[lo] + A[hi];
            if( sum < K ) {
                max = Math.max( max, sum );
                lo++;
            }
            else {
                hi--;
            }
        }
        
        return max;
    }
}
