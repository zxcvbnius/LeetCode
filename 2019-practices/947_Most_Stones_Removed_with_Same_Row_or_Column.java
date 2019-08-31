class Solution {
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();

        int len = stones.length, island = 0;

        for(int i = 0 ; i < len; i++) {
            int[] stone = stones[i];
            if( visited.contains(stone) ) continue;
            visited.add( stone );
            dfs( stones[i], stone, visited );
            island++;
        }
    }

    public void dfs(int[][] stones, int[] source, Set<int[]> visited) {
        int len = stones.length;
        for(int i = 0 ; i < len ; i++) {
            if( visited.contains(stones[i]) ) continue;
            if( source[0] == stones[i][0] || source[1] == stones[i][1] ) {
                visited.add( stones[i] );
                dfs(stones, stones[i], visited);
            }
        }
    }
}
