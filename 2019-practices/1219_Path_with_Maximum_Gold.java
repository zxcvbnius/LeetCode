class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                ans = Math.max( dfs(grid, new boolean[n][m], n, m, i, j, 0), ans );
            }
        }
        
        return ans;
    }
    
    public int dfs(int[][] grid, boolean[][] visited, int n, int m, int x, int y, int sum) {
        if( x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || grid[x][y] == 0) return sum;
        
        sum += grid[x][y];
        visited[x][y] = true;
        
        int max = 0;
        
        for(int[] dir : dirs) {
            max = Math.max( dfs(grid, visited, n, m, x + dir[0], y + dir[1], sum), max);
        }
        
        visited[x][y] = false;
        return max;
    }
}
