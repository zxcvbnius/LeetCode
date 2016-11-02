/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Result. "Your runtime beats 19.13% of java submissions :("
 */
 public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return;
        int line = 0;
        while(line < n /2 ) {
            for(int i = line; i < n - line - 1 ; i++) {
                rotateXY(matrix, i, line, n, i, line);
            }
            line++;
        }
        
    }
    
    public void rotateXY(int[][] matrix, int curX, int curY, int n, int startX, int startY) {
        int val   = matrix[curX][curY];
        int nextX = curY;
        int nextY = n - curX - 1;
        if(nextX == startX && nextY == startY) {
            // do nothing
        } else {
            rotateXY(matrix, nextX, nextY, n, startX, startY);            
        }
        matrix[nextX][nextY] = val;
    }
}
