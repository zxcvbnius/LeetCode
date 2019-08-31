class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 0, hi = 0;
        for( int w : weights ) {
            lo = Math.max( lo, w );
            hi += w;
        }
        int capacity = findCapacity(weights, lo, hi, D);
        return capacity;
    }
    
    public int findCapacity(int[] weights, int lo, int hi, int D) {
        int len = weights.length;
        while( lo < hi ) {
            int capacity = ( lo + hi ) / 2, count = 0, group = 0;
            for(int i = 0 ; i < len ; i++) {
                count += weights[i];
                if( count > capacity ) {
                    group++;
                    count = weights[i];
                }
            }
            if( group > D) lo = capacity + 1;
            else hi = capacity;
        }
        return lo;
    }
}
