class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // bellman-ford
        int maxVal = 100 * 100 + 1;
        int[] weights = new int[ N ];
        for(int i = 0 ; i < N ; i++) weights[i] = maxVal;
        weights[ K - 1 ] = 0;

        for(int i = 1 ; i < N ; i++) {
            for(int[] vector : times) {
                int source = vector[0] - 1, target = vector[1] - 1, time = vector[2];
                weights[ target ] = Math.min( weights[ target ], weights[ source ] + time );
            }
        }
        
        int res = -1;
        for(int i = 0 ; i < N ; i++) {
            res = Math.max( res, weights[i] );
        }

        return res >= maxVal ? -1 : res;
    }
}
