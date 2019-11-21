/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int left = 0, right = 0, val = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        helper(root);
        return Math.max( Math.max( left, right ), n - left - right - 1 ) > n / 2;
    }
    
    public int helper(TreeNode node) {
        if( node == null ) return 0;
        int _left = helper( node.left);
        int _right = helper( node.right);
        
        if( val == node.val ) {
            left = _left;
            right = _right;
        }
        
        return _left + _right + 1;
        
    }
}
