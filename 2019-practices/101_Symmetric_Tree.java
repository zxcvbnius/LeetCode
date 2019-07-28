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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compareTwoNode(root.left, root.right);
    }
    
    public boolean compareTwoNode(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        
        if(node1.val != node2.val) return false;
        
        boolean leftSideEqual = compareTwoNode(node1.left, node2.right);
        boolean rightSideEqual = compareTwoNode(node1.right, node2.left);
        
        return leftSideEqual && rightSideEqual;
    }
}
