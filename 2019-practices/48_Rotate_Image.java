class Solution {
    public void rotate(int[][] matrix) {
        // up-down reverse, then swap the symmetry
        int rowLen = matrix.length, colLen = matrix[0].length;
        int lo = 0, hi = rowLen - 1;
        while( lo < hi ) {
            for(int i = 0 ; i < colLen ; i++) {
                int tmp = matrix[lo][i];
                matrix[lo][i] = matrix[hi][i];
                matrix[hi][i] = tmp;
            }
            lo++;
            hi--;
        }
        
        // swap
        for(int i = 0; i < rowLen ; i++) {
            for(int j = i + 1 ; j < colLen ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
