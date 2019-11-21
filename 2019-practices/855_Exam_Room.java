class ExamRoom {

    // boolean[] seats;
    List<Integer> seats;
    int N = 0;
    
    public ExamRoom(int N) {
        this.seats = new LinkedList<>();
        this.N = N;
    }
    
    public int seat() {
        // if no ppl
        if( this.seats.size() == 0 ) {
            this.seats.add(0);
            return 0;
        }
        
        // first seat, last seat
        int first = this.seats.get(0);
        int last = seats.get( seats.size() - 1 );
        
        // find max dist
        int maxDist = Math.max( first, N - last - 1);
 
        int prev = -1;
        for( int i = 0 ; i < seats.size() ; i++ ) {
            if( prev >= 0 ) {
                maxDist = Math.max( maxDist, ( seats.get(i) - prev ) / 2 );
            }
            prev = seats.get(i);
        }
        
        // find ans 
        if( maxDist == first ) {
            seats.add(0, 0);
            return 0;
        }
        
        prev = -1;
        for( int i = 0 ; i < seats.size() ; i++ ) {
            if( prev >= 0 ) {
                int dist = ( seats.get(i) - prev ) / 2;
                if( maxDist == dist ) {
                    int pos = dist + prev;
                    seats.add( i, pos );
                    return pos;
                }
            }
            prev = seats.get(i);
        }

        seats.add(N - 1);
        return N - 1;
    }
    
    
    public void leave(int p) {
        int idx = -1;
        for(int i = 0 ; i < seats.size() ; i++) {
            if( seats.get(i) == p ) {
                idx = i;
                break;
            }
        }
        if(idx >= 0 ) seats.remove(idx);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
