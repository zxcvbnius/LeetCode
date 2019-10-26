class MedianFinder {
    
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 1, 2, 3, 5
        min = new PriorityQueue<>();
        // 4, 3, 2
        max = new PriorityQueue<>((x, y) -> y - x);
    }
    
    public void addNum(int num) {
        max.offer( num );
        min.offer( max.poll() );
        
        if( min.size() > max.size() ) {
            max.offer( min.poll() );
        }
    }
    
    public double findMedian() {
        boolean even = (max.size() + min.size()) % 2 == 0;
        if( even ) {
            return  1.0 *( min.peek() + max.peek() ) / 2;
        } else {
            return max.peek() * 1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
