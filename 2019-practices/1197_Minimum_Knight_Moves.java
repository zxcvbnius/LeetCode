class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] directions = new int[][]{
            {1, 2}, {2, 1}, {-1, 2}, {-2, 1},
            {1, -2}, {2, -1}, {-1, -2},{-2, -1}
        };

        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, Set<Integer>> visited = new HashMap<>();
        queue.offer( new int[]{0, 0} );

        int count = 0;

        x = Math.abs(x);
        y = Math.abs(y);

        while( queue.size() > 0 ) {
            Queue<int[]> tmp = new LinkedList<>();
            while( queue.size() > 0 ) {
                int[] pos = queue.poll();

                if( pos[0] == x && pos[1] == y ) return count;

                if( pos[0] < -2 || pos[1] < -2 ) continue;

                if( visited.containsKey(pos[0]) && visited.get(pos[0]).contains(pos[1]) ) continue;

                if( !visited.containsKey(pos[0]) ) visited.put( pos[0], new HashSet<>() );
                visited.get( pos[0] ).add( pos[1] );

                for(int[] dir : directions) {
                   tmp.offer( new int[]{ pos[0] + dir[0], pos[1] + dir[1] } );
                }
            }
            queue = tmp;
            count++;
        }
        return -1;
    }
}
