/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * Result. "Your runtime beats 68.91% of java submissions."
 */
 public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if(m == 0 || n == 0 || word.length() == 0) return false;
        
        int startW = word.charAt(0);
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(board[i][j] == startW) {
                    boolean res = dfs(board, word, 0, i, j, m, n);
                    if(res) return true;
                }
            }
        }
        return false;
        
    }
    public boolean dfs(char[][] board, String word, int curIndex, int curX, int curY, int m, int n) {
        
        if(curX >= m || curX < 0 || curY >= n || curY < 0) return false; // out of array bound       
        if(word.charAt(curIndex) != board[curX][curY]) return false; // word does not match
        if(curIndex == word.length() - 1) return true; // the end of word
        
        char curChar = board[curX][curY];
        board[curX][curY] = '*'; // * means the cell has been visited
        boolean res = dfs(board, word, curIndex + 1, curX + 1, curY, m, n)
            || dfs(board, word, curIndex + 1, curX - 1, curY, m, n)
            || dfs(board, word, curIndex + 1, curX, curY + 1, m, n)
            || dfs(board, word, curIndex + 1, curX, curY - 1, m, n);
        
        board[curX][curY] = curChar;
        return res ;
    }
}
