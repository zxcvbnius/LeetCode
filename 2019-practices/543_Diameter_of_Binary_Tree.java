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
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root, 0);
        return diameter;
    }
    
    int diameter = 0;
    public int dfs(TreeNode node, int depth) {
        if( node == null ) return depth;
        
        int left = dfs(node.left, depth);
        int right = dfs(node.right, depth);

        diameter = Math.max( left + right, diameter);

        return Math.max( left, right ) + 1;
    }
}
