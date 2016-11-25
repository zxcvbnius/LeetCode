/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * Result. "Your runtime beats 13.24% of java submissions." (Most ppl at the range)
 */
 public class Solution {
    
    private int count = 0;
    public boolean hasPathSum(TreeNode root, int target) {
        if(root == null) return false;
        getSum(root, 0, target);
        return count > 0;
    }
    
    public void getSum(TreeNode node, int curSum, int target) {
        
        curSum += node.val;
        if(node.left == null && node.right == null) {
            if(target == curSum) count++; // leaf
        }
        if(node.left != null) getSum(node.left, curSum, target);
        if(node.right != null) getSum(node.right, curSum, target);
    }
}
