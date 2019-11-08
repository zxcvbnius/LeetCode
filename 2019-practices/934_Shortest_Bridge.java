class Solution {
    int[][] dirs = new int[][]{
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    public int shortestBridge(int[][] A) {
        int rowLen = A.length, colLen = A[0].length;        
        boolean[][] visited = new boolean[ rowLen ][ colLen ];
        Queue<int[]> queue = new LinkedList<>();
        
        // find first island
        boolean found = false;
        for(int i = 0 ; i < rowLen ; i++) {
            if( found ) break;
            for(int j = 0 ; j < colLen ; j++) {
                if( A[i][j] == 1 ) {
                    bfs(i, j, rowLen, colLen, A, visited, queue);
                    found = true;
                    break;
                }
            }
        }
        
        int count = 0;        
        while( queue.size() > 0 ) {
            int size = queue.size();
            while( size-- > 0 ) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                
                for( int[] dir : dirs ) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    
                    if( newX < 0 || newX >= rowLen || newY < 0 || newY >= colLen ) continue; // illegal
                    if( visited[ newX ][ newY ] ) continue;
                    if( A[ newX ][ newY ] == 1 ) return count;
                    visited[ newX ][ newY ] = true;
                    queue.add( new int[]{ newX, newY} );
                }
            }
            count++;
        }
        
        return -1;
    }
    
    public void bfs(int x, int y, int rowLen, int colLen, int[][] A, boolean[][] visited, Queue<int[]> queue) {
        if( x < 0 || x >= rowLen || y < 0 || y >= colLen ) return; // illegal
        if( visited[x][y] || A[x][y] == 0 ) return; // already visited or cannot visit
        visited[x][y] = true;
        queue.offer(new int[]{ x, y});
        
        for(int[] dir : dirs ) {
            bfs( x + dir[0], y + dir[1], rowLen, colLen, A, visited, queue );
        }
    }
}
