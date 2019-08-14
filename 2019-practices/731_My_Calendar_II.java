// time complexity: o(n^2)
class MyCalendarTwo {
    
    List<int[]> calendar = null;
    List<int[]> overlaps = null;

    public MyCalendarTwo() {
        this.calendar =  new ArrayList<>();
        this.overlaps = new ArrayList<>();
    }
    
    // time complexity: O(N^2)
    public boolean book(int start, int end) {
        for( int[] overlap : overlaps ) {
            if( overlap[0] < end && overlap[1] > start ) return false; // already overlapped
        }
        
        for( int[] c : calendar ) {
            if( end > c[0] && c[1] > start ) {
                int max_start = Math.max( c[0], start );
                int min_end = Math.min( c[1], end );
                this.overlaps.add( new int[]{ max_start, min_end } );
            }
        }
        this.calendar.add( new int[]{ start, end} );
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
