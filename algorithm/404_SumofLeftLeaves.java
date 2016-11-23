/**
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * 
 * Result. "Your runtime beats 74.80% of java submissions."
 */
 public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return getValue(false, root);        
    }
    
    public int getValue(boolean isLeft, TreeNode node) {
        if(node.left == null && node.right == null) return isLeft ? node.val : 0;
        
        int sum = 0;
        if(node.left != null) sum += getValue(true, node.left);
        if(node.right != null) sum += getValue(false, node.right);
        
        return sum;
    }
}
