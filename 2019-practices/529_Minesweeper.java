class Solution {
    int[][] dirs = new int[][]{
        {0, 1}, {1, 0}, {0, -1}, {-1, 0},
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        
        int x = click[0], y = click[1];

        // case: X or B
        if( board[x][y] == 'X' || board[x][y] == 'B') return board;

        // case: M
        if( board[x][y] == 'M' ) {
            board[x][y] = 'X';
            return board;
        }
        
        // case: E
        Queue<int[]> queue = new LinkedList<>(); // only collect 'E'
        queue.offer( new int[]{x, y} );
        while( queue.size() > 0 ) {
            int[] pos = queue.poll();
            board[ pos[0] ][ pos[1] ] = 'B';
            
            int countBomb = 0;
            
            for( int[] dir : dirs ) {
                int newX = pos[0] + dir[0];
                int newY = pos[1] + dir[1];
                if( newX < 0 || newX >= m || newY < 0 || newY >= n ) continue;
                
                char ch = board[ newX ][ newY ];
                if( ch == 'M' || ch == 'X') countBomb++;
            }
            
            if( countBomb > 0 ) {
                board[ pos[0] ][ pos[1] ] = (char)(countBomb + '0');
            } else {
                board[ pos[0] ][ pos[1] ] = 'B';
                for( int[] dir : dirs ) {
                int newX = pos[0] + dir[0];
                int newY = pos[1] + dir[1];
                if( newX < 0 || newX >= m || newY < 0 || newY >= n ) continue;
                
                char ch = board[ newX ][ newY ];
                if( ch == 'E' ) {
                    queue.offer( new int[]{ newX, newY } );
                    board[ newX ][ newY ] = 'B';
                }
            }
            }
        }
        return board;
    }
}
