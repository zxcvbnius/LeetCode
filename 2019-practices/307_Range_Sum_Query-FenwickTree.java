class NumArray {
    
    class FenwickTree {
        private int size = -1;
        private int[] sums = null;
        public FenwickTree(int size) {
            this.size = size;
            this.sums = new int[ size ];
        }
        
        public int lowbit(int idx) {
            return idx & (-idx);
        }
        
        public void update(int idx, int val) {
            int i = idx;
            while( i < this.size ) {
                this.sums[ i ] += val;
                i += lowbit(i);
            }
        }
        
        public int preRange(int idx) {
            int i = idx, sum = 0;
            while( i > 0 ) {
                sum += this.sums[ i ];
                i -= lowbit(i);
            }
            return sum;
        }
    }

    private FenwickTree tree = null;
    private int[] nums = null;
    public NumArray(int[] nums) {
        this.nums = nums;
        if(nums == null || nums.length == 0) return;

        int size = nums.length;
        this.tree = new FenwickTree( size + 1 );
        for(int i = 0 ; i < size ; i++) this.tree.update( i + 1 , nums[i] );
    }
    
    public void update(int i, int val) {
        if( this.tree == null ) return;
        
        int updatedVal = val - this.nums[i];
        this.nums[i] = val;
        this.tree.update(i + 1 , updatedVal);
    }
    
    public int sumRange(int i, int j) {
        if( this.tree == null ) return 0;
        return this.tree.preRange(j + 1) - this.tree.preRange(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
