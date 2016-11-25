/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * Result. "Your runtime beats 22.92% of java submissions."
 */
public class Solution {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        getDepth(root, 0);
        return balanced;
    }
    
    public int getDepth(TreeNode node, int currentDepth) {
        currentDepth++;
        int left = 0, right = 0;
        if(node.left != null) {
            left = getDepth(node.left, 0);
        }
        if(node.right != null) {
            right = getDepth(node.right, 0);
        }
        // System.out.println("l: " + left + ", r: " + right + ", v: " + node.val);
        if(Math.abs(left - right) > 1) balanced = false; 
        return currentDepth + Math.max(left, right);
    }
}
