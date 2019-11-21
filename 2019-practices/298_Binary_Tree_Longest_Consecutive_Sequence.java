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
    
    int ans = 1;
    public int longestConsecutive(TreeNode root) {
        // node, count, parent node
        if( root == null ) return 0;
        
        dfs(root.left, root, 1);
        dfs(root.right, root, 1);
        
        return ans;
    }
    
    public void dfs(TreeNode node, TreeNode parent, int count) {
        if( node == null ) return;

        // calculate count
        if( node.val - parent.val == 1 ) {
            count++;
            ans = Math.max( ans, count );
        } else {
            count = 1;
        }
        
        dfs(node.left, node, count);
        dfs(node.right, node, count);
    }
}
