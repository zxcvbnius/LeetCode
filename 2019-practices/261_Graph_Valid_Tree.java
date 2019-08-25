class Solution {

    public boolean validTree(int n, int[][] edges) {        
        if( n <= 1 ) return true;
        
        List<Integer>[] nodes = new ArrayList[ n ];
        for(int i = 0 ; i < n ; i++) nodes[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            int source = edge[0];
            int target = edge[1];
            
            nodes[ source ].add( target );
            nodes[ target ].add( source );
        }
        
        Set<Integer> visited = new HashSet<>();
        int[] connected = new int[n];
        boolean res = dfs(nodes, 0, -1,  connected, new HashSet<>());
        
        boolean allConnected = true;
        for( int c : connected ) if( c == 0) return false;

        return res;
    }
    
    public boolean dfs(List<Integer>[] nodes, int node, int prev, int[] connected, Set<Integer> visited) {
        if( visited.contains(node) ) return false;
        
        connected[ node ] = 1;
        
        visited.add(node);
        for(int n : nodes[node] ) {
            if( prev == n ) continue;
            if( !dfs( nodes, n, node, connected, visited) ) return false;
        }
        
        visited.remove(node);
        
        return true;
    }
}
