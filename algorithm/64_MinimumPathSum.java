/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Result. "Your runtime beats 83.80% of java submissions."
 */
 public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] minCosts = new int[m][n];
        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                if(i == 0 && j ==0) minCosts[i][j] = 0;
                else minCosts[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                
                int minCost = minCosts[i][j]; 
                int val     = grid[i][j];
                if(i + 1 < m ) {
                    if(minCosts[i + 1][j] > minCost + val) {
                        minCosts[i + 1][j] = minCost + val;
                    } 
                } 
                if(j + 1 < n) {
                    if(minCosts[i][j + 1] > minCost + val) {
                        minCosts[i][j + 1] = minCost + val;
                    }
                }
                
            }
        }
        return minCosts[m-1][n-1] + grid[m-1][n-1];
    }
}
