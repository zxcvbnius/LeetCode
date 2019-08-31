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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        int val = root.val;
        return isValid(root, val);
    }
    
    public boolean isValid(TreeNode node, int val) {
        if( node == null) return true;
        if( node.val != val ) return false;
        if(node.left == null && node.right == null) return true;
        return isValid( node.left, val ) && isValid( node.right, val );
    }
}
