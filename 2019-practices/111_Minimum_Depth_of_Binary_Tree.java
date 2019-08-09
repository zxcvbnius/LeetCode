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
    public int minDepth(TreeNode root) {        
        return dfs(root, 0);   
    }
    
    public int dfs(TreeNode node, int minDepth) {
        if(node == null) return minDepth;
        
        int left = dfs(node.left, minDepth);
        int right = dfs(node.right, minDepth);
        
        if(left == 0 || right == 0) return right + left + 1;
        
        return Math.min(left, right) + 1;
    }
}
