/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * 
 * Example:
 * 
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 * 
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 * 
 * Result. "Your runtime beats 96.94% of java submissions."
 */
 public class Solution {
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    
    int sum = 0;
    private void helper(TreeNode curNode) {
        if(curNode == null) return;
        
        helper(curNode.right);
        
        sum += curNode.val;
        curNode.val = sum; 
        
        helper(curNode.left);
    }
}
