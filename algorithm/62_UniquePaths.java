/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
 
 // Sol1. DFS , spending too much time,  won't pass the test
 public class Solution {
    
    private int count = 0;
    
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        dfs(board, m, n, 0, 0);
        return count;
    }
    
    public boolean dfs(int[][] board, int m, int n ,int curX, int curY) {
        if(curX >= m || curY >= n) return false;
        if(board[curX][curY] != 0) return false;
        if(curX == m - 1 && curY == n - 1 ) {
            count++;
            return true;
        }
        
        board[curX][curY] = -1; // visited
        
        boolean w1 = dfs(board, m, n, curX + 1, curY);
        boolean w2 = dfs(board, m, n, curX, curY + 1);
        
        board[curX][curY] = 0;
        return w1 || w2;
    }
}

// Sol2. Dynamic Programming
// Result, your runtime beats 5.69% of java submissions.
public class Solution {
    
    private int count = 0;
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = 0 ; i < m ; i++) dp[i][0] = 1;
        for(int i = 0 ; i < n ; i++) dp[0][i] = 1;
        
        for(int i = 1 ; i < m ; i++) {
            for(int j = 1; j < n ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
