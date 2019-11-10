class Solution {
    public void solve(char[][] board) {
        if( board == null || board.length == 0) return;
        int rowLen = board.length, colLen = board[0].length;

        int col = colLen - 1, row = rowLen - 1;
        for( int i = 0 ; i < rowLen; i++ ) {
            if( board[ i ][ 0 ] == 'O' ) findIsland(i, 0, board);
            if( board[ i ][ col ] == 'O' ) findIsland(i, col, board);
        }

        for(int i = 0 ; i < colLen ; i++) {
            if( board[ 0 ][ i ] == 'O' ) findIsland(0, i, board);
            if( board[ row ][ i ] == 'O' ) findIsland(row, i, board);
        }

        for(int i = 0 ; i < rowLen ; i++) {
            for(int j = 0 ; j < colLen ; j++) {
                if( board[i][j] == '*' ) board[i][j] = 'O';
                else if( board[i][j] == 'O' ) board[i][j] = 'X';
            }
        }
    }

    public void findIsland(int x, int y, char[][] board) {
       if( board[x][y] != 'O' ) return; // cannot move on
       board[x][y] = '*'; // mark as visisted

       if( x - 1 >= 0 ) findIsland(x - 1, y, board);
       if( y - 1 >= 0 ) findIsland(x, y - 1, board);
       if( x + 1 < board.length ) findIsland(x + 1, y, board);
       if( y + 1 < board[0].length ) findIsland(x , y + 1, board);
    }
}
