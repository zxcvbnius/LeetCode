class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, 0, new boolean[bikes.length], 0);
        return min;
    }
    
    int min = Integer.MAX_VALUE;
    public void dfs(int[][] workers, int[][] bikes, int worker_no,
                    boolean[] used, int sum) {
        if( worker_no == workers.length ) {
            min = Math.min( min, sum );
            return;
        }
        
        if( sum > min ) return;
        
        for(int i = 0 ; i < bikes.length ; i++) {
            if( used[i] ) continue;
            used[i] = true;
            dfs( workers,
                 bikes,
                 worker_no + 1,
                used,
                sum + getDistance(workers[ worker_no], bikes[ i ] )
                 );
            used[i] = false;
        }
        
    }
    
    public int getDistance(int[] worker, int[] bike) {
        return Math.abs( worker[0] - bike[0] ) + Math.abs( worker[1] - bike[1] );
    }
}
