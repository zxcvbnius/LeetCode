class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if( n == 1 ) {
            res.add(0);
            return res;
        }

        List<Set<Integer>> edgeList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) edgeList.add( new HashSet<>() );
        for(int[] edge : edges) {
            edgeList.get( edge[0] ).add( edge[1] );
            edgeList.get( edge[1] ).add( edge[0] );
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i = 0 ; i < edgeList.size() ; i++) {
            if( edgeList.get(i).size() == 1 ) leaves.add(i); // leaves
        }

        int remaining = n;
        while( remaining > 2 ) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer leaf : leaves ) {
              int neighbor = edgeList.get( leaf ).iterator().next();
              edgeList.get( neighbor ).remove( leaf );
              if( edgeList.get( neighbor ).size() == 1 ) newLeaves.add( neighbor );
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
