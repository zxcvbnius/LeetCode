/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 * Example 1:
 * Input:
 * 
 *     2
 *    / \
 *   1   3
 * 
 * Output:
 * 1
 * Example 2: 
 * Input:
 * 
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * 
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 * 
 * Result. "Your runtime beats 74.58%  of java submissions."
 */
 public class Solution {
    int leftDepth = 0;
    int leftValue = 0;
    public int findBottomLeftValue(TreeNode root) {
        if(root.right == null && root.left == null) return root.val;
        if(root.right != null) findMaxDepth(root.right, 0);
        if(root.left != null) findMaxDepth(root.left, 0);
        return leftValue;
    }
    
    public void findMaxDepth(TreeNode currentNode, int depth) {
        if(currentNode.left == null && currentNode.right == null) {
            if(depth >= leftDepth) {
                leftDepth = depth;
                leftValue  = currentNode.val;
            }
        }
        if(currentNode.right != null) findMaxDepth(currentNode.right, depth + 1);
        if(currentNode.left != null) findMaxDepth(currentNode.left, depth + 1);
    }
}
