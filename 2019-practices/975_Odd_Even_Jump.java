class Solution {
    public int oddEvenJumps(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = A.length;
        int[][] res = new int[ len ][2]; // 0: odd, 1: even
        
        res[ len - 1][0] = res[ len - 1][1] = 1; // last one must be true
        map.put( A[ len - 1], len -1 );
        
        for(int i = len - 2 ; i >= 0 ; i--) {
            Integer lager = map.ceilingKey( A[i] );
            if( lager != null ) {
                int idx = map.get( lager );
                res[i][0] = res[ idx ][1];
            }
            
            Integer smaller = map.floorKey( A[i] );
            if( smaller != null ) {
                int idx = map.get( smaller );
                res[i][1] = res[ idx ][0];
            }
            
            map.put( A[i], i );
        }
        
        int count = 0;
        for(int[] val : res ) {
            if( val[0] == 1 ) count++;
        }
        
        return count;
    }
}
