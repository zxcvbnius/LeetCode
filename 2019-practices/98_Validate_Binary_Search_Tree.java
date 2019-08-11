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
    public Long max = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if( root.left == null && root.right == null) return true;
        return inorder(root);
    }
    
    public boolean inorder(TreeNode root) {
        // use in-order tree => sorted
        if(root == null) return true;

        boolean left = inorder(root.left);

        boolean isVaild = true;
        if(max < root.val) max = new Long(root.val);
        else { isVaild = false; }

        boolean right = inorder(root.right);

        return left && right && isVaild;
    }
}
