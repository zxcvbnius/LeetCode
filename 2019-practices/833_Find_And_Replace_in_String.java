class Solution {
    public int maxDistToClosest(int[] seats) {
        int start = 0, end = 0, maxLen = 0;
        for(int i = 0 ; i < seats.length ; i++) {
            if( seats[i] == 0 ) {
                int s = i, e = i;
                while( e < seats.length && seats[e] == 0 ) {
                    e++;
                }
                int len = (e - s + 1) / 2;
                if( s == 0 || e == seats.length) len = e - s;
                
                if( len > maxLen ) {
                    start = s;
                    end = e;
                    maxLen = len;
                }
                i = e - 1;
            }
        }
        
        return maxLen;
    }
}
