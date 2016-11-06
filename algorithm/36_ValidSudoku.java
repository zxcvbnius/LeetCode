/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Result. "Your runtime beats 44.85% of java submissions :("
 */
 public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0 ; i < n; i++) {
            if( !rowValidate(board[i]) ) return false;
        }
        for(int j = 0 ; j < n ; j++) {
            char[] chars = new char[10];
            for(int i = 0 ; i < n; i++) {
                chars[i] = board[i][j];
            }
            if( !colValidate(chars) ) return false;
        }
        
        for(int i = 0 ; i < n ; i+= 3) {
            for(int j = 0 ; j < n; j+= 3) {
                if( !gridValidate(board, i, i + 2, j, j + 2) ) return false;
            }
        }
        return true;
    }
    
    public boolean rowValidate(char[] row) {
        boolean[] used = new boolean[10];
        for(int i = 0 ; i < row.length ; i++) {
            int val = Character.getNumericValue(row[i]);
            if(val < 0) continue;
            if(used[val]) return false;
            used[ val ] = true;
        }
        return true;
    }
    public boolean colValidate(char[] col) {
        boolean[] used = new boolean[10];
        for(int i = 0 ; i < col.length ; i++) {
            int val = Character.getNumericValue(col[i]);
            if(val < 0) continue;
            if(used[val]) return false;
            used[ val ] = true;
        }
        return true;
    }
    
    public boolean gridValidate(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        boolean[] used = new boolean[10];
        for(int i = startRow ; i <= endRow ; i++) {
            for(int j = startCol ; j <= endCol ; j++) {
                int val = Character.getNumericValue(board[i][j]);
                if(val < 0) continue;
                if(used[val]) return false;
                used[val] = true;
            }
        }
        return true;
    }
}
