class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col ; j++) {
                if( i + 1 < row && j + 1 < col) {
                    if( matrix[i][j] != matrix[i + 1][j + 1] ) return false;
                }
            }
        }   
        return true;
    }
}
