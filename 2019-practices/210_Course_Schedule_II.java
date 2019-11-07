class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> list = new ArrayList<>();

        int[] res = new int[ numCourses ];
        int idx = 0;

        for(int n : numCourses) list.add( new HashSet<>() );

        for(int[] prerequist : prerequistes) {
            list.get( prerequist[0] ).add( prerequist[1] );
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < list.size() ; i++) {
            if( list.get(i).size() == 0 ) {
                queue.offer( i );
                res[ idx++ ] = i;
            }
        }

        while( queue.size() > 0 ) {
            int p = queue.poll();
            for(int i = 0 ; i < list.size() ; i++) {
                if( list.get(i).contains(p) ) {
                    list.get(i).remove(p);
                    if( list.get(i).size() == 0 ) {
                        queue.offer(i);
                        res[ idx++ ] = i;
                    }
                }
            }
        }

        return res;
    }
}
