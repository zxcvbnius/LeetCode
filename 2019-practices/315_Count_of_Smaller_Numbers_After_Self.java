class Solution {

    // update: O(log N)
    // query: O(log N)
    class FenwickTree {
        private int size = 0;
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
                this.sums[i] += val;
                i += lowbit(i);
            }
        }
        
        public int preSum(int idx) {
            int i = idx, sum = 0;
            while( i > 0 ) {
                sum += this.sums[i];
                i -= lowbit(i);
            }
            return sum;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null) return null;
        if(nums.length == 0) return new ArrayList<>();
        int size = nums.length;
        
        // init _nums & sort
        int[] _nums = new int[ size ];
        for(int i = 0 ; i < size ; i++) _nums[i] = nums[i];
        quicksort(_nums, 0, size - 1);
        
        // give ranks, key is num, value is rank
        HashMap<Integer, Integer> ranks = new HashMap<>();
        for(int i = 0 ; i < size ; i++) {
            ranks.put( _nums[i], i + 1 );
        }
        
        // build a Fenwick Tree
        FenwickTree tree = new FenwickTree( size + 1 );
        
        // Caclulate results
        List<Integer> list = new ArrayList<>();
        for(int i = size - 1 ; i >= 0 ; i--) {
            int rank = ranks.get(nums[i]);
            int count = tree.preSum( rank - 1 );
            list.add( count );
            tree.update(rank, 1 );
        }
        
        // reverse
        Collections.reverse(list);
        
        return list;
    }
    
    public void quicksort(int[] nums, int lo, int hi) {
        int i = lo, j = hi, pivot = nums[ (lo + hi) / 2 ];
        while( i <= j ) {
            while( nums[i] < pivot ) i++;
            while( nums[j] > pivot ) j--;
            
            if( i <= j ) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        
        if( i < hi) quicksort( nums, i, hi);
        if( lo < j) quicksort( nums, lo, j);
    }
}
