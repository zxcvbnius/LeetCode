/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Result. "Your runtime beats 18.95% of java submissions."
 */
 public class Solution {
    public int maximalSquare(char[][] matrix) {
        if( matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] temp = new int[m + 1][n + 1];
        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                if( matrix[i-1][j-1] == '1' ) {
                    temp[i][j] = Math.min( Math.min( temp[i][j-1], temp[i-1][j-1] ) , temp[i-1][j]) + 1;
                    result = Math.max( temp[i][j], result);
                }
            }
        }
        return result * result;
    }

}
