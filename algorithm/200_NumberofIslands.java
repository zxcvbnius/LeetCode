/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 *   11110
 *   11010
 *   11000
 *   00000
 *  
 * Result. "Your runtime beats 56.83% of java submissions."
 */
 public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        int count = 0, n = grid.length, m = grid[0].length;
        // System.out.println("n : " + n + ", m : " + m);
        for(int i = 0; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if( grid[i][j] == '1' ) {
                    dfs(grid, i, j, n , m);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        if( grid[i][j] == '0') return;
        grid[i][j] = '0';
        if(i > 0 ) dfs(grid, i - 1, j, n, m);
        if(j > 0 ) dfs(grid, i, j - 1, n, m);
        if(i < n - 1) dfs(grid, i + 1, j, n, m);
        if(j < m - 1) dfs(grid, i, j + 1, n, m);
    }
}
