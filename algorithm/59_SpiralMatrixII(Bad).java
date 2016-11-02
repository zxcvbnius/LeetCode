/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 *  [
 *     [ 1, 2, 3 ],
 *     [ 8, 9, 4 ],
 *     [ 7, 6, 5 ]
 *   ]
 * Result. "Your runtime beats 18.65% of java submissions :("
 */
 
 public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][]matrix = new int[n][n];   
        if(n == 0 ) return matrix;
        
        int current = 0;
        int line = 0;
        int curX = -1;
        int curY = 0;
        
        while(true) {
            
            curX++;            
            for(; curX < n - line ; curX++) {
                current += 1;
                matrix[curY][curX] = current;
            } 
            curX--;
            
            if(curX == curY) break; // if n is odd
            
            curY++;
            for( ; curY < n - line ; curY++ ) {
                current += 1;
                matrix[curY][curX] = current;
            }
            curY--;
            
            curX--;
            for(;curX >= line ; curX-- ) {
                current += 1;
                matrix[curY][curX] = current;
            }
            curX++;
            
            line++;
            
            if(curY == line) break; // if n is even
            
            curY--;
            for(;curY >= line ; curY-- ) {
                current += 1;
                matrix[curY][curX] = current;
            }
            curY++;
            
            
        }
        return matrix;
    }
}
