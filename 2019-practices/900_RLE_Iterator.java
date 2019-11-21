class RLEIterator {
    
    List<Integer> valList = new LinkedList<>();
    List<Integer> counter = new LinkedList<>();
    
    int curIdx = 0;

    public RLEIterator(int[] A) {
        for(int i = 0 ; i < A.length ; i += 2) {
            int count = A[i], val = A[ i + 1 ];
            valList.add( val );
            counter.add( count );
        }
    }
    
    public int next(int n) {
        int idx = curIdx;
        while( idx < valList.size() ) {
            int remain = counter.get( idx ) - n;
            if( remain >= 0 ) {
                curIdx = idx;

                counter.set(idx, remain);
                return valList.get( idx );
            }
            counter.set( idx , 0);
            n = Math.abs(remain);
            idx++;
        }
        
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
