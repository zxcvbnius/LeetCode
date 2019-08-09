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
    public int count = 0;
    public int minCameraCover(TreeNode root) {
        // (0): leaf
        // (1): set camera (nodes)
        // (2): non-set camera (nodes)
        // (3) : null case we don't care
        if( dfs(root) < 1 ) count++;
        return count;
    }
    
    public int dfs(TreeNode node) {
        if(node == null) return 3;
        if(node.left == null && node.right == null) return 0;
    
        int left = node.left == null ? 3 : dfs(node.left);
        int right = node.right == null ? 3 : dfs(node.right);
        
        if(left == 0 || right == 0) { // parent
            count++;
            return 1;
        }
        
        return (left == 1 || right == 1) ? 2 : 0;
    }
}
