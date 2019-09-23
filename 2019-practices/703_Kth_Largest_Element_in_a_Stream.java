class KthLargest {
    
    private final PriorityQueue<Integer> pq;
    private final int limit;
    public KthLargest(int k, int[] nums) {
        limit = k;
        pq = new PriorityQueue(k);
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if( pq.size() < limit ) {
            pq.offer( val );
        } else if( pq.peek() < val ) {
            pq.poll();
            pq.offer( val );
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
