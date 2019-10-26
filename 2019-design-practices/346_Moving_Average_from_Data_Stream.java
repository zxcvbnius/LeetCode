class MovingAverage {
    
    Queue<Integer> queue;
    int size;
    int sum = 0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        if( queue.size() >= size ) {
            int removed = queue.poll();
            sum -= removed;
        }
        
        queue.offer( val );
        sum += val;
        return 1.0 * sum / queue.size(); 
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
