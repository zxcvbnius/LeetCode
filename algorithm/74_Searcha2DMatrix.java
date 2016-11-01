/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given target = 3, if target is an element of the matrix, then return true.
 * Result. "Your runtime beats 69.10% of java submissions."
 */
 
 public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     int m = matrix.length;
     int n = matrix[0].length;
     
     if(m == 0 || n == 0) return false;
     
     int lineIndex = -1;
     for(int i = 0 ; i < m; i++) {
         if(target >= matrix[i][0] && target <= matrix[i][n-1]) {
             lineIndex = i;
             break;
         }
     }
     
     if(lineIndex < 0) return false; 
     
     // binary search
     int left  = 0;
     int right = n - 1;
     while(true) {
         if(left >= right) {
            if(matrix[lineIndex][left] == target) return true;    
            else return false;
         }         
         int mid = (left + right) / 2;
         if(matrix[lineIndex][mid] > target) {
             right = mid;
         } else if(matrix[lineIndex][mid] < target) {
             left = mid + 1;
         } else {
             return true;
         }
     }
    }
}
