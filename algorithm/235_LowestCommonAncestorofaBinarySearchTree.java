/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *        _______6______
 *       /              \
 *    ___2__          ___8__
 *   /      \        /      \
 *   0      _4       7       9
 *         /  \
 *         3   5
 * 
 * Result. "Your runtime beats 13.36% of java submissions."
 */
 public class Solution {
    private TreeNode p, q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root != null) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if( root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }        
        }
        return null;
    }
}
