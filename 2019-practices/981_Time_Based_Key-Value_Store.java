class TimeMap {
    
    class Node {
        String word;
        int timestamp;
        public Node(String w, int t) {
            word = w;
            timestamp = t;
        }
    }

    /** Initialize your data structure here. */
    HashMap<String, List<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if( !map.containsKey(key) ) map.put( key, new ArrayList<>() );
        map.get(key).add( new Node(value, timestamp) );
    }
    
    public String get(String key, int timestamp) {
        if( !map.containsKey(key) ) return "";
        List<Node> nodes = map.get(key);
        
        int lo = 0;
        int hi = nodes.size() - 1;
        
        if( timestamp >= nodes.get( hi ).timestamp ) return nodes.get( hi ).word;
        if( timestamp < nodes.get(lo).timestamp ) return "";
        
        while( lo < hi ) {
            int mid = (hi - lo) / 2 + lo;

            if(nodes.get( mid ).timestamp == timestamp ) {
                return nodes.get( mid ).word;
            }

            if( nodes.get( mid ).timestamp < timestamp ) {
                if( nodes.get(mid+1).timestamp > timestamp ) return nodes.get( mid ).word;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return nodes.get(lo).word;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
