class NumMatrix {
    
    class FenwickTree {
        private int rowSize = -1;
        private int colSize = -1;
        private int[][] matrix = null;
        
        public FenwickTree(int rowSize, int colSize) {
            this.rowSize = rowSize;
            this.colSize = colSize;
            this.matrix = new int[ rowSize ][ colSize ];
        }
        
        public int lowBit(int idx) {
            return idx & (-idx);
        }
        
        public void update(int row, int col, int updatedVal ) {
            int i = row;
            while( i < this.rowSize ) {
                int j = col;
                while( j < this.colSize ) {
                    this.matrix[i][j] += updatedVal;    
                    j += lowBit(j);
                }
                i += lowBit(i);
            }
        }
        
        public int preSum(int row, int col) {
            int i = row, sum = 0;
            while( i > 0 ) {
                int j = col;
                while( j > 0 ) {
                    sum += this.matrix[i][j];
                    j -= lowBit(j);
                }
                i -= lowBit(i);
            }
            return sum;
        }
    }

    private int colSize = 0;
    private int rowSize = 0;
    private int[][] matrix = null;
    private FenwickTree tree = null;
    
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.rowSize = matrix.length;
    
        if( this.rowSize == 0 ) return;
        
        this.colSize = matrix[0].length;
        this.tree = new FenwickTree( this.rowSize + 1, this.colSize + 1);
        for(int i = 0 ; i < this.rowSize ; i++) {
            for(int j = 0 ; j < this.colSize ; j++ ) {
                this.tree.update( i + 1, j + 1, this.matrix[i][j] );
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if(this.rowSize == 0 || this.colSize == 0) return;

        int update = val - this.matrix[ row ][ col ];
        this.matrix[ row ][ col ] = val;
        this.tree.update( row + 1, col + 1, update );
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(this.rowSize == 0 || this.colSize == 0) return 0;
        return this.tree.preSum(row2+1, col2+1) + this.tree.preSum(row1, col1) - this.tree.preSum(row1, col2+1) - this.tree.preSum(row2+1, col1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
