class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int targetX = grid.length - 1, targetY = grid[0].length - 1;
        boolean[][] visited = new boolean[ targetX + 1 ][ targetY + 1];
        
        int[][] dirs = new int[][]{
            {0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}
        };
        
        if( grid[0][0] != 0 ) return -1;
        
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer( new int[]{ 0, 0 });

        while( queue.size() > 0 ) {
            int size = queue.size();
            while( size-- > 0 ) {
                int[] pos = queue.poll();
                
                if( pos[0] == targetX && pos[1] == targetY ) return count;
                
                for(int[] dir : dirs) {
                    int x = pos[0] + dir[0], y = pos[1] + dir[1];
                    if( x < 0 || y < 0 || x > targetX || y > targetY ) continue; // out of grid
                    if( grid[x][y] == 0 && !visited[ x ][ y ]) {
                        queue.offer( new int[]{ x, y});
                        visited[ x ][ y ] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
