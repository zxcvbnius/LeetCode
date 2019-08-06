class Solution {
    public int totalFruit(int[] tree) {
        int lo = 0, hi = 0, len = tree.length, maxSize = -1;

        HashMap<Integer, Integer> map = new HashMap<>(); // value, index
        
        while(hi < len) {
            if( map.size() <= 2 ) {
                map.put( tree[hi], hi );
                hi++;
            }
            
            if( map.size() > 2) {
                // there are more than two characters in this substring
                // need to remove left-most one
                int left_most = len, left_most_val = -1;
                for( Integer value : map.keySet() ) {
                    int index = map.get( value );
                    if( left_most > index) {
                        left_most = index;
                        left_most_val = value;
                    }
                }
                map.remove( left_most_val );
                lo = left_most + 1;
            }
            
            int size = hi - lo;
            if(maxSize < size) maxSize = size;
        }
        
        return maxSize;
    }
}
