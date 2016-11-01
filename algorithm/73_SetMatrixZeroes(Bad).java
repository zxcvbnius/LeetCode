/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Result. "Your runtime beats 6.07% of java submissions."
 */
 public class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0) return;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int r : rows) {
            for(int i = 0 ; i < n ; i++) {
                matrix[r][i] = 0;
            }
        }
        
        for(int c : cols) {
            for(int i = 0 ; i < m ; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
