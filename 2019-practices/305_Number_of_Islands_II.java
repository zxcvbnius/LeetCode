class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        
        int key = 0;
        
        for( int[] p : positions ) {
            List<Integer> matches = new ArrayList<>();

            for( Integer k : map.keySet() ) {
                List<int[]> land = map.get(k);
                if( helper(land, p) ) {
                    matches.add( k );
                }
            }
            // if(p[0] == 4 && p[1] == 3) System.out.println("matches: " + matches.size());
            
            int size = matches.size();
            // no match
            if( size == 0 ) {
                List<int[]> list = new ArrayList<>();
                list.add( p );
                map.put( key++, list );
            } else if( size == 1 ) {
                map.get( matches.get(0) ).add(p);
            } else {
                // multiple matches
                int keep = matches.get(0);
                map.get( keep ).add(p);

                for(int i = 1 ; i < size ; i++) {
                    int k = matches.get(i);

                    List<int[]> l = map.get( k );
                    map.get( keep ).addAll(l);
                    map.remove( k );
                }
            }
            
            res.add( map.size() );
        }
                
        return res;
    }
    
    public boolean helper(List<int[]> land, int[] pos) {
        int[][] dirs = new int[][]{ {0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for( int[] p : land ) {
            // if(pos[0] == 4 && pos[1] == 3) System.out.println("x: " + p[0] + ", y: " + p[1]);
            
            for(int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                if( x == pos[0] && y == pos[1] ) return true;
            }
        }
        return false;
    }
}
