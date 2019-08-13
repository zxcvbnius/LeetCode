class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int wLen = workers.length;
        int bLen = bikes.length;
        
        // according to condtion, no more than 2000 workers and bikes
        // so we can use bucket sort
        List<int[]>[] lists = new ArrayList[ 2001 ];
        for(int i = 0 ; i < wLen; i++ ) {
            for(int j = 0 ; j < bLen ; j++) {
                int[] worker = workers[i];
                int[] bike = bikes[j];

                int distance = dist( worker, bike );
                if( lists[distance] == null ) lists[distance] = new ArrayList<>();
                lists[distance].add( new int[]{i, j} );
            }
        }
        
        int[] res = new int[ wLen ];
        boolean[] assigned = new boolean[ wLen ]; // worker with # is assigned a bike
        boolean[] occupied = new boolean[ bLen ]; // bike with # is occupied
        for(int i = 0 ; i < 2001 ; i++) {
            if( lists[i] != null ) {
                List<int[]> pairs = lists[i];
                for(int[] p : pairs) {
                    if( assigned[ p[0] ] != true && occupied[ p[1] ] != true ) {
                        res[ p[0] ] = p[1];
                        assigned[ p[0] ] = true;
                        occupied[ p[1] ] = true;
                    }
                }
            }
        }
        
        return res;
    }
    
    public int dist(int[] worker, int[] bike) {
        int distance = Math.abs( worker[0] - bike[0] ) + Math.abs( worker[1] - bike[1] );
        return distance;
    }
}
