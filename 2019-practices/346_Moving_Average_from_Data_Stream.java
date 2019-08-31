class MovingAverage {

    /** Initialize your data structure here. */
    private int size;
    private Queue<Integer> queue = null;
    private int curSum = 0;
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        if( this.queue.size() < this.size ) {
            this.queue.offer( val );
            this.curSum += val;
        }
        else {
            int firstElement = this.queue.poll();
            this.queue.offer( val );
            this.curSum -= firstElement;
            this.curSum += val;
        }
        
        return 1.0 * this.curSum / this.queue.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
