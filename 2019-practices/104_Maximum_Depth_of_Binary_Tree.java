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
    public int maxDepth(TreeNode root) {
        int depth = dfs(root, 0);
        return depth;
    }
    
    public int dfs(TreeNode node, int depth) {
        if( node == null) return depth;
        int left = dfs(node.left, depth);
        int right = dfs(node.right, depth);
        return Math.max(left, right) + 1;
    }
}
