class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int idx = 0, len = intervals.length;

        int[] starts = new int[ intervals.length ];
        int[] ends = new int[ intervals.length ];
        

        for( int[] interval : intervals ) {
            starts[idx] = interval[0];
            ends[idx] = interval[1];
            idx++;
        }
        
        Arrays.sort( starts );
        Arrays.sort( ends );
        
        int sIdx = 0, eIdx = 0, available = 1;
        while( sIdx < len ) {
            if( starts[sIdx] < ends[eIdx] ) {
                available--;
                sIdx++;
            } else {
                available++;
                eIdx++;
            }
            
            if( available < 0 ) return false;
        }
        return true;
    }
}
