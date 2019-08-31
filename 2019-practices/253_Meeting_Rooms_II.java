class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] start = new int[ len ];
        int[] end = new int[ len ];
        for(int i = 0 ; i < len ; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort( start );
        Arrays.sort( end );

        int rooms = 0, available = 0;
        int s = 0, e = 0; // indics
        while( s < len ) {
            if( start[s] < end[e] ) {
                if( available == 0 ) {
                    rooms++;
                } else {
                    available--;
                }
                s++;
            } else {
                available++;
                e++;
            }
        }
        return rooms;
    }
}
