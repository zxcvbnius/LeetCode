class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int size = rooms.size();
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> hasKeys = new LinkedList<>();
        
        for(int key : rooms.get(0) ) {
            hasKeys.offer( key );
            visited.add( key );
        }

        while( hasKeys.size() > 0 ) {
            int key = hasKeys.poll();
            
            for(int k : rooms.get(key) ) {
                if( !visited.contains(k) ) {
                    visited.add( k );
                    hasKeys.offer( k );
                }
            }
        }
        
        boolean foundAll = true;
        for(int i = 1 ; i < size ; i++ ) {
            if( !visited.contains(i) ) {
                foundAll = false;
                break;
            }
        }
        
        return foundAll;
    }
}
