// Sol. TreeMap
// Time complexity: O( nlogn  )
class MyCalendar {

    private TreeMap<Integer, Integer> booking = null; // start, end
    public MyCalendar() {
        this.booking = new TreeMap<>();
    }
    
    public boolean book(int start2, int end2) {
        Integer start1 = this.booking.floorKey( start2 ); // find the max value < "start1"

        if( start1 != null && this.booking.get(start1) > start2 ) return false;
        
        start1 = this.booking.ceilingKey( start2 ); // find the min value > "start1"
        if( start1 != null && end2 > start1 ) return false;
        
        this.booking.put( start2, end2 );
        return true;
    }
}

// Sol. DFS - faster
// Time complexity: O( logN )
class MyCalendar {
    
    class TreeNode {
        int start;
        int end;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private TreeNode root = null;
    private boolean isBooked = true;
    public MyCalendar() {
        
    }
    
    public TreeNode dfs(TreeNode node, int start, int end) {
        this.isBooked = true;

        if( node == null) return new TreeNode(start, end);
        
        if( node.start >= end ) {
            node.left = dfs( node.left, start, end);
        } else if(node.end <= start ) {
            node.right = dfs( node.right, start, end);
        } else {
            this.isBooked = false;
        }
        return node;
    }
    
    public boolean book(int start, int end) {
        if(this.root == null) {
            this.root = new TreeNode( start, end );
            return true;
        }

        dfs( this.root, start, end);
        return this.isBooked;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
