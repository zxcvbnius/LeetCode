class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] cached = new int[m][n];
        
        int max = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                int len = dfs( matrix, m, n, i, j, cached);
                max = Math.max( len, max );
            }
        }
        
        return max;
    }
    
    public int dfs(int[][] matrix, int m, int n, int i, int j, int[][] cached) {
        if( cached[i][j] != 0) return cached[i][j];
        
        int max = 1;
        for(int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if( x < 0 || x >= m || y < 0 || y >= n || matrix[i][j] >= matrix[x][y] ) continue;
            
            int len = 1 + dfs( matrix, m, n, x, y, cached);
            max = Math.max(len, max);
        }
        cached[i][j] = max;
        return max;
    }
}
