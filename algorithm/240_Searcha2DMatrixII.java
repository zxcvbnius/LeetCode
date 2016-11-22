
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 *   Integers in each row are sorted in ascending from left to right.
 *   Integers in each column are sorted in ascending from top to bottom.
 * 
 *   For example,
 *   
 *   Consider the following matrix:
 *   
 *   [
 *     [1,   4,  7, 11, 15],
 *     [2,   5,  8, 12, 19],
 *     [3,   6,  9, 16, 22],
 *     [10, 13, 14, 17, 24],
 *     [18, 21, 23, 26, 30]
 *   ]
 *  
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * Result. "Your runtime beat 66.89% of java submissions :("
 */
 public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null) return false;
        int m = matrix.length, n = matrix[0].length, row = 0, col = n - 1;
        
        while(row < m && col >= 0) {
            if( matrix[row][col] == target ) return true;
            else if( matrix[row][col] > target ) {
                col--;
            } else { // matrix[row][col] < target
                row++;
            }
        }
        return false;
    }
}
