/**
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 * 
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1 
 * 
 * Result. "Your runtime beats 22.95% of java submissions."
 */
 
// Switch brothers

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left  = root.right;
        root.right = temp;
        if(root.left != null) invertTree(root.left);
        if(root.right != null) invertTree(root.right);
        return root;
    }
}
