/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
 * Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island 
 * (i.e., one or more connected land cells). The island doesn't have "lakes" 
 * (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. The grid is rectangular, 
 * width and height don't exceed 100. Determine the perimeter of the island.
 *
 * Runtime: 146 ms
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null) return 0;
        
        int res = 0, m = grid.length, n = grid[0].length;
        
        for(int j = 0 ; j < n ; j++) {
            for(int i = 0 ; i < m; i++) {
                if(grid[i][j] == 1) {
                    res += 4;
                    if(j - 1 >= 0 && grid[i][j-1] == 1) res -= 2;
                    if(i - 1 >= 0 && grid[i-1][j] == 1) res -= 2;
                }
            }
        }
        return res;
        
    }
}
